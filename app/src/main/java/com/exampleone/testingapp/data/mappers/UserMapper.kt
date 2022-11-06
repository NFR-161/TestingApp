package com.exampleone.testingapp.data.mappers

import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem

class UserMapper {

    fun mapUserItemToDbModel(userItem: UserItem) = UserModel(
        id = userItem.id,
        enabled = userItem.enabled,
        name = userItem.name,
        picUrl = userItem.picUrl
    )

    fun mapDbModelToUserItem(userModel: UserModel) = UserItem(
        id = userModel.id,
        enabled = userModel.enabled,
        name = userModel.name,
        picUrl = userModel.picUrl
    )
}