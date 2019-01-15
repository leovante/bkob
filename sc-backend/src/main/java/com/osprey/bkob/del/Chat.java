//package com.osprey.bkob.del;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="Chat")
//public class Chat{
//
//    // PrimaryKey
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    private String firstName;
//    private String lastName;
//
//    public Chat() {}
//
//    public Chat(String s) {
//    }
//
//
//    @Override
//    public String toString() {
//        return String.format(
//                "User[id=%d, firstName='%s']",
//                id, firstName);
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//}