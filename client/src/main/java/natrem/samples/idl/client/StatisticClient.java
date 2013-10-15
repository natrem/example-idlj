package natrem.samples.idl.client;

import natrem.sample.idl.client.statistics.OrbStatistics;
import natrem.sample.idl.client.statistics.OrbStatisticsHelper;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 * Hello world!
 * 
 */
public class StatisticClient {
    static OrbStatistics statServer;

    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef = orb
                    .resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is
            // part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            statServer = OrbStatisticsHelper.narrow(ncRef.resolve_str(OrbStatistics.NAME));

            System.out.println("Obtained a handle on server object: "
                    + statServer);
            statServer.publish("TestStatistic");

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
