package com.tgz;

import java.util.Date;

public class ResponsibilityTest {
    public static void main(String[] args) {
        ApproverDirector approverDirector=new ApproverDirector("赵志斌主任",1);
        ApproverExecutiveDirector approverExecutiveDirector=new ApproverExecutiveDirector("张华主管",2);
        ApproverMainDirector approverMainDirector=new ApproverMainDirector("郑克爽总管",3);
        ApproverChairman approverChairman=new ApproverChairman("吴克董事长",4);

        approverDirector.setApprovernext(approverExecutiveDirector);
        approverExecutiveDirector.setApprovernext(approverMainDirector);
        approverMainDirector.setApprovernext(approverChairman);

        approverDirector.approver(new Request(1,3011f));
    }
}


class Request{
    int id;
    float money=0.0f;
    String type;
    Date date;
    //等等

    public Request(int id,Float money){
        this.id=id;
        this.money=money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}



abstract class Approver{
    String name;
    int level;
    Approver approvernext;

    public Approver(String name,int level){
        this.name=name;
        this.level=level;
    }

    abstract void approver(Request request);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Approver getApprovernext() {
        return approvernext;
    }

    public void setApprovernext(Approver approvernext) {
        this.approvernext = approvernext;
    }
}

class ApproverDirector extends Approver{
    public ApproverDirector(String name, int level) {
        super(name, level);
    }

    @Override
    void approver(Request request) {
        if(request.money<=1000){
            System.out.println("我是："+this.name+request.id+"号单子已被我审批");
        }else {
            if(this.approvernext==null){
                System.out.println("我的上级还是空着的");
            }else {
                approvernext.approver(request);
            }
        }
    }
}

class ApproverExecutiveDirector extends Approver{
    public ApproverExecutiveDirector(String name, int level) {
        super(name, level);
    }

    @Override
    void approver(Request request) {
        if(request.money<=5000&&request.money>1000){
            System.out.println("我是："+this.name+request.id+"号单子已被我审批");
        }else {
            if(this.approvernext==null){
                System.out.println("我的上级还是空着的");
            }else {
                approvernext.approver(request);
            }
        }
    }
}


class ApproverMainDirector extends Approver{
    public ApproverMainDirector(String name, int level) {
        super(name, level);
    }

    @Override
    void approver(Request request) {
        if(request.money<30000&&request.money>5000){
            System.out.println("我是："+this.name+request.id+"号单子已被我审批");
        }else {
            if(this.approvernext==null){
                System.out.println("我的上级还是空着的");
            }else {
                approvernext.approver(request);
            }
        }
    }
}


class ApproverChairman extends Approver{
    public ApproverChairman(String name, int level) {
        super(name, level);
    }

    @Override
    void approver(Request request) {
        if(request.money>30000){
            System.out.println("我是："+this.name+request.id+"号单子已被我审批");
        }else {
            System.out.println("");

        }
    }
}
