package com.xt.se.oop;

/**
 * @author xt
 * @Desc
 */
public class LockDoorMain {
    public static void main(String[] args) {
        LockDoor lockDoor = new LockDoor();
        lockDoor.openDoor();
        lockDoor.closeDoor();
        lockDoor.openLock();
        lockDoor.closeLock();

        System.out.println(LockDoor.i);
    }
}
