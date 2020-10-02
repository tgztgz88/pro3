package com.tgz;

public class CommandTest {
    public static void main(String[] args) {
        Invoke invoke01=new Invoke();
        TVReceiver tvReceiver=new TVReceiver();
        TVOnConcreteCommand tvOnConcreteCommand=new TVOnConcreteCommand(tvReceiver);
        TVOffConcreteCommand tvOffConcreteCommand=new TVOffConcreteCommand(tvReceiver);
        invoke01.setCommand(0,tvOnConcreteCommand,tvOffConcreteCommand);
        System.out.println("----------按下电视开键-----------");
        invoke01.pushedon(0);
        System.out.println("----------按下电视关键-----------");
        invoke01.pushedoff(0);
        System.out.println("----------按下撤销键-----------");
        invoke01.pushedundo();
    }
}

interface Command{
    public void excute();
    public void undo();
}

class NoCommand implements Command{
    @Override
    public void excute() {

    }

    @Override
    public void undo() {

    }
}

class TVReceiver{
   public void actionon(){
       System.out.println("电灯打开了");
   }

    public void actionoff(){
        System.out.println("电灯关闭了");
    }
}

class TVOnConcreteCommand implements Command{
    private TVReceiver tvReceiver;

    public TVOnConcreteCommand(TVReceiver t){
        this.tvReceiver=t;
    }

    @Override
    public void excute() {
        tvReceiver.actionon();
    }

    @Override
    public void undo() {
        tvReceiver.actionoff();
    }
}

class TVOffConcreteCommand implements Command{
    private TVReceiver tvReceiver;


    public TVOffConcreteCommand(TVReceiver t){
        this.tvReceiver=t;
    }
    @Override
    public void excute() {
     tvReceiver.actionoff();
    }

    @Override
    public void undo() {
     tvReceiver.actionon();
    }
}

class Invoke{
    private Command[] commandon;
    private Command[] commandoff;
    private Command lastcommand;

    public Invoke(){
        commandon=new Command[5];
        commandoff=new Command[5];
        for (int i=0;i<commandoff.length;i++){
            commandoff[i]=new NoCommand();
            commandon[i]=new NoCommand();
        }
    }

    public void setCommand(int no,Command commandonadd,Command commandoffadd){
        commandon[no]=commandonadd;
        commandoff[no]=commandoffadd;
    }

    public void pushedon(int no){
        commandon[no].excute();
        lastcommand=commandon[no];
    }

    public void pushedoff(int no){
        commandoff[no].excute();
        lastcommand=commandoff[no];
    }

    public void pushedundo(){
        lastcommand.undo();
    }
}
