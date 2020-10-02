package com.tgz.Builder_Pattern;

public class Builder_Pattern {
    public static void main(String[] args) {
        CommonsHouseBuilder commonsHouseBuilder=new CommonsHouseBuilder();
        HouseDirector houseDirector=new HouseDirector(commonsHouseBuilder);
        House house01=houseDirector.constructHouse();
        System.out.println(house01);
    }
}

class House{
    private String roofed;
    private String wall;
    private String basics;
    private String part1;
    private String part2;

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getBasics() {
        return basics;
    }

    public void setBasics(String basics) {
        this.basics = basics;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "House{" +
                "roofed='" + roofed + '\'' +
                ", wall='" + wall + '\'' +
                ", basics='" + basics + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                '}';
    }
}

interface HouseBuilder{        //抽象建造者  定义好一定要做的工作 建哪些东西
    public House house=null;
    public void buildRoofed();
    public void buildWall();
    public void buildBasics();
    public void buildPart1();
    public void buildPart2();

    public House buildHouse();
}

class CommonsHouseBuilder implements HouseBuilder{    //具体建造者实现抽象建造者  定义好一定要做的工作对应目标产品的细节 造多厚的墙 多深的地基
    House house=new House();

    @Override
    public void buildRoofed() {
        house.setRoofed("小型屋顶");
    }

    @Override
    public void buildWall() {
        house.setWall("小型墙");
    }

    @Override
    public void buildBasics() {
        house.setBasics("小型地基");
    }

    @Override
    public void buildPart1() {
        house.setPart1("单人床");
    }

    @Override
    public void buildPart2() {
        house.setPart2("单人卫生间");
    }

    @Override
    public House buildHouse() {
        return this.house;
    }


}


class HouseDirector{         //作为指挥者  要指挥按照什么顺序来创建  所以内部必须要有一个具体建造者
    private HouseBuilder houseBuilder;

    public  HouseDirector(HouseBuilder houseBuilder){   //构造方法来传入具体建造者
        this.houseBuilder=houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {  //set方法传入具体建造者
        this.houseBuilder = houseBuilder;
    }

    //处理建造房子的流程
    public House constructHouse(){
        houseBuilder.buildPart1();
        houseBuilder.buildBasics();
        houseBuilder.buildWall();
        houseBuilder.buildRoofed();
        houseBuilder.buildPart2();
        return houseBuilder.buildHouse();
    }
}