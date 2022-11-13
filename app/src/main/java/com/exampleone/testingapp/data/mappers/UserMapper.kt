package com.exampleone.testingapp.data.mappers

import com.exampleone.testingapp.data.UserModel
import com.exampleone.testingapp.domain.UserItem

class UserMapper {

    fun mapUserItemSubscribeToDbModel(userItem: UserItem) = UserModel(
        id = userItem.id,
        enabled = userItem.enabled,
        name = userItem.name,
        picUrl = userItem.picUrl
    )

    fun mapDbModelToUserItemSubscribe(userModel: UserModel) = UserItem(
        id = userModel.id,
        enabled = userModel.enabled,
        name = userModel.name,
        picUrl = userModel.picUrl
    )

    fun mapListItemToDbModel(us: UserItem, userItem: List<UserItem>): List<UserModel> {
        return userItem.map {
            UserModel(
                id = us.id,
                enabled = us.enabled,
                name = us.name,
                picUrl = us.picUrl
            )
        }
    }


}