package com.example.designpattern.builder;
/*
通常用来将一个复杂的对象的构造过程分离, 让使用者可以根据需要选择创建过程.
另外, 当这个复杂的对象的构造包含很多可选参数时, 那Builder模式可以说是不二之选了.
 */
public class HotDryNoodlesWithBuilder {
    private boolean addShallot;
    private boolean addParsley;
    private boolean addChili;
    private boolean addSauerkraut;
    public HotDryNoodlesWithBuilder(Builder builder){
        this.addShallot = builder.addShallot;
        this.addParsley = builder.addParsley;
        this.addChili = builder.addChili;
        this.addSauerkraut = builder.addSauerkraut;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("A bowl of noodles has:");
        if (this.addShallot) { builder.append("葱花."); }
        if (this.addParsley) { builder.append("香菜."); }
        if (this.addChili) { builder.append("辣椒."); }
        if (this.addSauerkraut) { builder.append("酸菜."); }

        return builder.toString();
    }

    public static class Builder{
        private boolean addShallot;
        private boolean addParsley;
        private boolean addChili;
        private boolean addSauerkraut;
        public Builder(){

        }
        public Builder withShallot(){
            this.addShallot = true;
            return this;
        }
        public Builder withParsley(){
            this.addParsley = true;
            return this;
        }
        public Builder withChili(){
            this.addChili = true;
            return this;
        }
        public Builder withSauerkraut(){
            this.addSauerkraut = true;
            return this;
        }

        public HotDryNoodlesWithBuilder builder(){
            return new HotDryNoodlesWithBuilder(this);
        }
    }
}
