package cn.aura.controller;

import java.util.concurrent.Callable;

public class BaseController {
    public  String visit(Runnable runnable, String... options) {
        try {
            runnable.run();
            return "BaseControllerSuccess";
        } catch (Throwable e) {
            return "BaseControllerError";
        }
    }
    public String visit(Callable<String> callable, String... options) {
        try {
            return "BaseControllerSuccess";
        } catch (Throwable e) {
            return "BaseControllerError";
        }
    }
}
