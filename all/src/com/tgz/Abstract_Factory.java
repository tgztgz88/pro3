package com.tgz;

public class Abstract_Factory {
    public static void main(String[] args) {
        System.out.println("弓箭手：");
        Role shoutmanRole=new ShoutmanRole();
       Armor shoutmanarmor= shoutmanRole.getarmor();
        Weapon shoutmanweapon= shoutmanRole.getweapon();
        shoutmanarmor.armor();
        shoutmanweapon.weapon();
        System.out.println("战士：");
        Role warriorRole=new WarriorRole();
        Armor warriorarmor= warriorRole.getarmor();
        Weapon warriorweapon= warriorRole.getweapon();
        warriorarmor.armor();
        warriorweapon.weapon();
    }
}

interface Weapon{
    void weapon();
}

interface Armor{
    void armor();
}

interface Role{
    Weapon getweapon();
    Armor  getarmor();
}

class ShoutmanWeapon implements Weapon{

    @Override
    public void weapon() {
        System.out.println("use " +  "弓箭");
    }
}

class ShoutmanArmor implements Armor{

    @Override
    public void armor() {
        System.out.println("use 布甲");
    }
}

class ShoutmanRole implements Role{
    @Override
    public ShoutmanWeapon getweapon() {
        return new ShoutmanWeapon();
    }

    @Override
    public ShoutmanArmor getarmor() {
        return new ShoutmanArmor();
    }
}


class WarriorWeapon implements Weapon{

    @Override
    public void weapon() {
        System.out.println("use " +  "巨剑");
    }
}

class WarriorArmor implements Armor{

    @Override
    public void armor() {
        System.out.println("use 重甲");
    }
}

class WarriorRole implements Role{
    @Override
    public WarriorWeapon getweapon() {
        return new WarriorWeapon();
    }

    @Override
    public  WarriorArmor getarmor() {
        return new WarriorArmor();
    }
}