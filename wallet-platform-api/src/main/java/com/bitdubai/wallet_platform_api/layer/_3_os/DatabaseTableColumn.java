package com.bitdubai.wallet_platform_api.layer._3_os;

/**
 * Created by ciencias on 01.02.15.
 */
public interface DatabaseTableColumn {
    
    public String getName ();
    
    public void setName (String name);

    public DatabaseDataType getType ();
    
    public void setType(DatabaseDataType type);
    
}
