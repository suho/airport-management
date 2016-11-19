/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.User;
import model.ModelUser;

/**
 *
 * @author DELL
 */
public class ControllerUser {
    private ModelUser modelUser;
    public ControllerUser(int idEmployee){
        modelUser = new ModelUser();
    }

    public int checkUser(User objUser) {
        return modelUser.checkUser(objUser);
    }

    public int addUser(User objUser) {
        int id = modelUser.addItem(objUser);
        return id;
    }

    public int editUser(User objUser) {
        int result = 0;
        result = modelUser.editItem(objUser);
        return result;
    }
}
