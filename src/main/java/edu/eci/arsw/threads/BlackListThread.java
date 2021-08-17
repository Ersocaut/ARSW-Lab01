package edu.eci.arsw.threads;

import edu.eci.arsw.blacklistvalidator.HostBlackListsValidator;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class BlackListThread extends Thread{

    private String host;
    private int a, b;
    private int ocurrences = 0;
    private HostBlacklistsDataSourceFacade skds;

    public BlackListThread(String host, int a, int b, HostBlacklistsDataSourceFacade skds){
        this.host = host;
        this.a = a;
        this.b = b;
        this.skds = skds;
    }

    public int getOcurrences(){
        return ocurrences;
    }

    public void run(){
        for (int i = a; i < b; i++){
            if (skds.isInBlackListServer(i,host)){
                ocurrences++;
            }
        }
    }
}
