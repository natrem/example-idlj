package natrem.sample.idl.server;

import natrem.sample.idl.server.statistics.OrbStatisticsPOA;

public class OrbStatisticsImpl extends OrbStatisticsPOA {

    public void publish(String stat) {
        System.out.println("Publish " + stat);
    }

}
