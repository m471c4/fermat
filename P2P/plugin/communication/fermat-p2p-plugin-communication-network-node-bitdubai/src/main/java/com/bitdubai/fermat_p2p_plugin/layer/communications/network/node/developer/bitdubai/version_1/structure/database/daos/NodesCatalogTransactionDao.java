/*
 * @#NodesCatalogTransactionDao.java - 2015
 * Copyright bitDubai.com., All rights reserved.
 * You may not modify, use, reproduce or distribute this software.
 * BITDUBAI/CONFIDENTIAL
 */
package com.bitdubai.fermat_p2p_plugin.layer.communications.network.node.developer.bitdubai.version_1.structure.database.daos;

import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.Database;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableRecord;
import com.bitdubai.fermat_p2p_plugin.layer.communications.network.node.developer.bitdubai.version_1.structure.database.CommunicationsNetworkNodeP2PDatabaseConstants;
import com.bitdubai.fermat_p2p_plugin.layer.communications.network.node.developer.bitdubai.version_1.structure.entities.NodesCatalogTransaction;

import java.sql.Timestamp;

/**
 * The Class <code>com.bitdubai.fermat_p2p_plugin.layer.communications.network.node.developer.bitdubai.version_1.structure.database.daos.NodesCatalogTransactionDao</code>
 * <p/>
 * Created by Roberto Requena - (rart3001@gmail.com) on 23/11/15.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public class NodesCatalogTransactionDao  extends AbstractBaseDao<NodesCatalogTransaction> {

    /**
     * Constructor with parameter
     *
     * @param dataBase
     */
    public NodesCatalogTransactionDao(Database dataBase) {
        super(dataBase, CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_TABLE_NAME, CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_FIRST_KEY_COLUMN);
    }

    /**
     * (non-javadoc)
     * @see AbstractBaseDao#getEntityFromDatabaseTableRecord(DatabaseTableRecord)
     */
    @Override
    protected NodesCatalogTransaction getEntityFromDatabaseTableRecord(DatabaseTableRecord record) throws InvalidParameterException {

        NodesCatalogTransaction entity = new NodesCatalogTransaction();

        entity.setHashId(record.getStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_HASH_ID_COLUMN_NAME));
        entity.setLastConnectionTimestamp(new Timestamp(record.getLongValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_LAST_CONNECTION_TIMESTAMP_COLUMN_NAME)));
        entity.setDefaultPort(record.getIntegerValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_DEFAULT_PORT_COLUMN_NAME));
        entity.setIdentityPublicKey(record.getStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_IDENTITY_PUBLIC_KEY_COLUMN_NAME));
        entity.setIp(record.getStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_IP_COLUMN_NAME));
        entity.setName(record.getStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_NAME_COLUMN_NAME));
        entity.setLastLatitude(record.getDoubleValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_LAST_LATITUDE_COLUMN_NAME));
        entity.setLastLongitude(record.getDoubleValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_LAST_LONGITUDE_COLUMN_NAME));
        entity.setRegisteredTimestamp(new Timestamp(record.getLongValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_REGISTERED_TIMESTAMP_COLUMN_NAME)));
        entity.setTransactionType(record.getStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_OFFLINE_COUNTER_COLUMN_NAME));

        return entity;
    }

    /**
     * (non-javadoc)
     * @see AbstractBaseDao#getDatabaseTableRecordFromEntity
     */
    @Override
    protected DatabaseTableRecord getDatabaseTableRecordFromEntity(NodesCatalogTransaction entity) {

        DatabaseTableRecord databaseTableRecord = getDatabaseTable().getEmptyRecord();

        databaseTableRecord.setStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_HASH_ID_COLUMN_NAME, entity.getHashId());
        databaseTableRecord.setLongValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_LAST_CONNECTION_TIMESTAMP_COLUMN_NAME, entity.getLastConnectionTimestamp().getTime());
        databaseTableRecord.setIntegerValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_DEFAULT_PORT_COLUMN_NAME, entity.getDefaultPort());
        databaseTableRecord.setStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_IDENTITY_PUBLIC_KEY_COLUMN_NAME, entity.getIdentityPublicKey());
        databaseTableRecord.setStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_IP_COLUMN_NAME, entity.getIp());
        databaseTableRecord.setStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_NAME_COLUMN_NAME, entity.getName());
        databaseTableRecord.setDoubleValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_LAST_LATITUDE_COLUMN_NAME, entity.getLastLatitude());
        databaseTableRecord.setDoubleValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_LAST_LONGITUDE_COLUMN_NAME, entity.getLastLongitude());
        databaseTableRecord.setLongValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_REGISTERED_TIMESTAMP_COLUMN_NAME, entity.getRegisteredTimestamp().getTime());
        databaseTableRecord.setStringValue(CommunicationsNetworkNodeP2PDatabaseConstants.NODES_CATALOG_TRANSACTION_TRANSACTION_TYPE_COLUMN_NAME, entity.getTransactionType());

        return databaseTableRecord;
    }
}
