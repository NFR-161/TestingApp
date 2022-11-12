package com.exampleone.testingapp.data.mappers

import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItemSubscribe

class UserMapper {

    fun mapUserItemSubscribeToDbModel(userItemSubscribe: UserItemSubscribe) = UserModel(
        id = userItemSubscribe.id,
        enabled = userItemSubscribe.enabled,
        name = userItemSubscribe.name,
        picUrl = userItemSubscribe.picUrl
    )

    fun mapDbModelToUserItemSubscribe(userModel: UserModel) = UserItemSubscribe(
        id = userModel.id,
        enabled = userModel.enabled,
        name = userModel.name,
        picUrl = userModel.picUrl
    )
}