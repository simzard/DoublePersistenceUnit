/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Person;
import facades.PersonFacade;
import javax.persistence.Persistence;

/**
 *
 * @author simon
 */
public class Tester {
    public static void main(String[] args) {
        new Tester().test();
    }
    
    public void test() {
        PersonFacade pFacadeTest = new PersonFacade(Persistence.createEntityManagerFactory("DoublePersistenceUnitPUTest"));
        PersonFacade pFacadeProd = new PersonFacade(Persistence.createEntityManagerFactory("DoublePersistenceUnitPUProd"));
        
        
        // make a few persons for the test database:
        Person p1 = new Person("Kurt");
        Person p2 = new Person("Albert");
        Person p3 = new Person("Svend");
        
        // persist them 
        pFacadeTest.createPerson(p1);
        pFacadeTest.createPerson(p2);
        pFacadeTest.createPerson(p3);
        
        // make a few persons for the production database:
        Person q1 = new Person("Alice");
        Person q2 = new Person("Peter");
        Person q3 = new Person("Rolf");
        
        // persist them 
        pFacadeProd.createPerson(q1);
        pFacadeProd.createPerson(q2);
        pFacadeProd.createPerson(q3);
        
        
        
    }
}
