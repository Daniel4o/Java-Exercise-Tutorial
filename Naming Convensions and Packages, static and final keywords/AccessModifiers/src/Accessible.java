    // Visibilities of:

    // 1.  interface Accessible:
    // If the interface is set to a package then it would be
    // package private. It would be accessible to all classes in the package

    // 2. int SOME_CONSTANT
    // Visibility is set to public. All interface variables are
    // public static final.

    // 3. public void methodA()
    // It's just public

    // 4. methodB and methodC
    // They are public because all interface methods are
    // automatically public (i.e. the lack of an access
    // modifier does not imply package private)

 interface Accessible {

        int SOME_CONSTANT = 100;
        public void methodA();
        void methodB();
        boolean methodC();
}
