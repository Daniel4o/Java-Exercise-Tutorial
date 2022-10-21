package com.example.todolist;


import com.example.todolist.datamodel.TodoData;
import com.example.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class HelloController {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;

    public void initialize() {
        listContextMenu = new ContextMenu();
        // Creating the delete menu item and associate an event handler with it
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        // Adding the delete item menu item itself to context menu
        listContextMenu.getItems().addAll(deleteMenuItem);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if(t1 != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d,yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });
        // Filtering on button selected for today's deadline items and all items
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return (todoItem.getDeadline().equals(LocalDate.now()));
            }
        };

        filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), wantAllItems);

        // Sorting the todolist items by date. Using Comparator to compare the items
        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });
         // Ordering by creation
      //  todoListView.setItems(TodoData.getInstance().getTodoItems());
        // Ordering by date
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean b) {
                        super.updateItem(todoItem, b);
                        if(b) setText(null);
                        else {
                            setText(todoItem.getShortDescription());

                            // If the due dated was passed or it's due today
                            if(todoItem.getDeadline().isBefore(LocalDate.now())) {
                                setTextFill(Color.PURPLE);
                            }
                            else if(todoItem.getDeadline().isEqual(LocalDate.now())) {
                                setTextFill(Color.RED);
                            }
                            // If the todolist due date is till tomorrow
                                else if(todoItem.getDeadline().isEqual(LocalDate.now().plusDays(1))) {
                                  setTextFill(Color.YELLOW);
                            }
////                                else if(todoItem.getDeadline().compareTo(LocalDate.now().plusWeeks(1)))
////                                    setTextFill(Color.GREEN);
//                            }
                                else {
                                    setTextFill(Color.BLUE);
                            }
                        }

                    }
                };

                // Adding a delete menu (right click) and associating
                // the menu with the listview
                // The item will be automatically deleted (without using code)
                // this is because we're using data binding
                // Using anonymous method  (lambda function)
                cell.emptyProperty().addListener(
                        (obs,wasEmpty,isNowEmpty) -> {
                            if (isNowEmpty) cell.setContextMenu(null);
                            else cell.setContextMenu(listContextMenu);
                        });
                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Use this dialog to crate a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem  newItem = controller.processResults();

            if(newItem.getDeadline() == null || newItem.getShortDescription() == null) {
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("Validate Fields!");
               alert.setHeaderText(null);
               alert.setContentText("Please enter a description and date!");
               alert.showAndWait();
               showNewItemDialog();
            }
            else {
                todoListView.getSelectionModel().select(newItem);
            }
        }
    }

    // Adding a delete option when Delete key is clicked
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        // If Delete key is pressed
        if(selectedItem != null) {
            if(keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }

   public void deleteItem(TodoItem item) {
        // Adding confirmation dialog
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setTitle("Delete Todo Item");
       alert.setHeaderText("Delete item: " + item.getShortDescription());
       alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out.");
       Optional<ButtonType> result = alert.showAndWait();

       if(result.isPresent() && (result.get() == ButtonType.OK)) {
           TodoData.getInstance().deleteTodoItem(item);
       }
   }

   // Setting the view based on condition.
   @FXML
    public void handleFilterButton() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
       if(filterToggleButton.isSelected()) {
            filteredList.setPredicate(wantTodaysItems);
            if(filteredList.isEmpty()) {
                itemDetailsTextArea.clear();
                deadlineLabel.setText("");
            }
            // If selected item on all item's is also in the today's list select it after the toggle
            else if(filteredList.contains(selectedItem)) {
                todoListView.getSelectionModel().select(selectedItem);
            }
            // else item selected in all items is not in today's items.
            // Show the first item in today's list
            else {
                todoListView.getSelectionModel().selectFirst();
            }
       }
       else {
           filteredList.setPredicate(wantAllItems);
           todoListView.getSelectionModel().select(selectedItem);
       }
   }
   @FXML
    public void handleExit() {
        Platform.exit();
   }
}
