package edu.eci.arsw.threads;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

/**
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version version 1.0 8/16/2021
 */
public class HostBlackListThread extends Thread{
    private int a;
    private int b;
    private int ocurrencesCount=0;
    private int checkedListsCount=0;
    private static int blackListAlarmCount;
    private HostBlacklistsDataSourceFacade skds;

    String ipAddress;

    public HostBlackListThread (int a, int b, String ipAddress, HostBlacklistsDataSourceFacade skds, int BLACK_LIST_ALARM_COUNT){
        this.a = a;
        this.b = b;
        this.ipAddress = ipAddress;
        this.skds = skds;
        blackListAlarmCount = BLACK_LIST_ALARM_COUNT;
    }


    @Override
    public void run() {
        for (int i=a;i<b && ocurrencesCount<blackListAlarmCount;i++){
            checkedListsCount++;

            if (skds.isInBlackListServer(i, ipAddress)){
                ocurrencesCount++;
            }
        }
    }

    public int getOcurrencesCount() {
        return ocurrencesCount;
    }

    public int getCheckedListsCount() {
        return checkedListsCount;
    }
}
