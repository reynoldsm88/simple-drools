package org.reynoldsm88.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.reynoldsm88.model.Person;

public class RulesTest {

    @Test
    public void basicDrools() {
        KieSession session = KieServices.Factory.get().newKieClasspathContainer().newKieSession( "test-ksession" );

        Person p = new Person();
        p.setName( "Michael" );

        session.insert( p );
        int numRules = session.fireAllRules();

        assertEquals( 1, numRules );

    }
}
