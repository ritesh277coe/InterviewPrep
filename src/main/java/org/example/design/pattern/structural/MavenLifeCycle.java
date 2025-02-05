package org.example.design.pattern.structural;

//Below class hides all complexity of compiler tool chain and provides simple FACADE to interact with IDE
public class MavenLifeCycle {
    //Maven lifecycle
    void clean(){
        System.out.println("Clean the whole build");
    }
    void validate(){
        System.out.println("Does pre compile validations");
    }
    void compile(){
        validate();
        System.out.println("Does compile");
    }
    void test(){
        compile();
        System.out.println("Runs unit tests");
    }
    void package1(){
        test();
        System.out.println("Create jar");
    }
    void verify() {
        package1();
        System.out.println("Runs integ tests if any");
    }
    void install() {
        verify();
        System.out.println("Install jar in local cache");
    }
    void deploy(){
        install();
        System.out.println("Install jar in remote artifactory location");
    }
}
