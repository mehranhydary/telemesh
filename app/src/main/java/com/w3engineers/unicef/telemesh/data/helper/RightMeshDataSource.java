package com.w3engineers.unicef.telemesh.data.helper;

import android.annotation.SuppressLint;
import android.os.RemoteException;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.w3engineers.ext.strom.App;
import com.w3engineers.ext.viper.application.data.remote.BaseRmDataSource;
import com.w3engineers.ext.viper.application.data.remote.model.BaseMeshData;
import com.w3engineers.ext.viper.application.data.remote.model.MeshAcknowledgement;
import com.w3engineers.ext.viper.application.data.remote.model.MeshData;
import com.w3engineers.ext.viper.application.data.remote.model.MeshPeer;
import com.w3engineers.unicef.telemesh.TeleMeshUser.*;

import java.util.ArrayList;
import java.util.List;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [22-Oct-2018 at 7:12 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: telemesh.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [22-Oct-2018 at 7:12 PM].
 * * --> <Second Editor> on [22-Oct-2018 at 7:12 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [22-Oct-2018 at 7:12 PM].
 * * --> <Second Reviewer> on [22-Oct-2018 at 7:12 PM].
 * * ============================================================================
 **/
public class RightMeshDataSource extends BaseRmDataSource {

    private static RightMeshDataSource rightMeshDataSource;

    private List<String> userIds;

    protected RightMeshDataSource(byte[] profileInfo) {
        super(App.getContext(), profileInfo);

        userIds = new ArrayList<>();
    }

    public static RightMeshDataSource getRmDataSource(RMUserModel rmUserMe) {
        if (rightMeshDataSource == null) {
            byte[] bytes = rmUserMe.toByteArray();
            rightMeshDataSource = new RightMeshDataSource(bytes);
        }
        return rightMeshDataSource;
    }

    @Override
    protected void onRmOn() {
        super.onRmOn();

        RmDataHelper.getInstance().prepareDataObserver();
    }

    /**
     * During send data to peer
     * @param rmDataModel -> A generic data model which contains userData, type and peerId
     * @return return the send message id
     */
    public int DataSend(RMDataModel rmDataModel) {

        try {

            MeshData meshData = new MeshData();
            meshData.mType = (byte) rmDataModel.getDataType();
            meshData.mData = rmDataModel.getRawData().toByteArray();
            meshData.mMeshPeer = new MeshPeer(rmDataModel.getUserMeshId());

            return sendMeshData(meshData);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * During receive a peer this time onPeer api is execute
     * @param profileInfo -> Got a peer data (profile information and meshId)
     */
    @SuppressLint("TimberArgCount")
    @Override
    protected void onPeer(BaseMeshData profileInfo) {

        try {
            String userId = profileInfo.mMeshPeer.getPeerId();

            if (!userIds.contains(userId)) {

                userIds.add(userId);

                RMUserModel.Builder rmUserModel = RMUserModel.newBuilder()
                        .mergeFrom(profileInfo.mData);

                if (rmUserModel != null) {

                    rmUserModel.setUserId(userId);
                    RmDataHelper.getInstance().userAdd(rmUserModel.build());
                }
            }
        }catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    /**
     * When a peer is gone or switched the another network
     * this time onPeerGone api is executed
     * @param meshPeer - > It contains the peer id which is currently inactive in mesh
     */
    @Override
    protected void onPeerGone(MeshPeer meshPeer) {

        String userId = meshPeer.getPeerId();

        if (userIds.contains(userId)) {
            RmDataHelper.getInstance().userLeave(meshPeer);
        }
    }

    /**
     * This api execute during we receive data from network
     * @param meshData -> Contains data and peer info also
     */
    @Override
    protected void onData(MeshData meshData) {

        RMDataModel rmDataModel = RMDataModel.newBuilder()
                .setUserMeshId(meshData.mMeshPeer.getPeerId())
                .setRawData(ByteString.copyFrom(meshData.mData))
                .setDataType(meshData.mType)
                .build();

        RmDataHelper.getInstance().dataReceive(rmDataModel, true);
    }

    /**
     * The sending data status is success this time we got a success ack using this api
     * @param meshAcknowledgement -> Contains the success data id and user id
     */
    @Override
    protected void onAcknowledgement(MeshAcknowledgement meshAcknowledgement) {

        RMDataModel rmDataModel = RMDataModel.newBuilder()
                .setUserMeshId(meshAcknowledgement.mMeshPeer.getPeerId())
                .setRecDataId(meshAcknowledgement.id)
                .build();

        RmDataHelper.getInstance().ackReceive(rmDataModel);
    }

    @Override
    public void onRmOff() {
        super.onRmOff();
    }
}