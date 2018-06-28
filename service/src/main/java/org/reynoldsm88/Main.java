package org.reynoldsm88;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.reynoldsm88.model.Person;

public class Main {

    public static void main( String[] args ) {
        KieContainer container = KieServices.Factory.get().newKieContainer( KieServices.Factory.get().newReleaseId( "org.reynoldsm88", "rules", "0.0.1-SNAPSHOT" ) );
        KieScanner scanner = KieServices.Factory.get().newKieScanner( container );
        scanner.scanNow();
        scanner.stop();

        Person p = new Person();
        p.setName( "Michael" );

        KieSession session = container.newKieSession( "test-ksession" );
        session.insert( p );

        int ruleFiredCount = session.fireAllRules();

        System.out.println( "# of rules fired : " + ruleFiredCount );

    }

}
