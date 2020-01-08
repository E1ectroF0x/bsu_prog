//
//  JsonStruct.swift
//  tableSettigins
//
//  Created by Владимир Лишаненко on 1/6/20.
//  Copyright © 2020 Li. All rights reserved.
//

import Foundation
import UIKit

struct Profile: Codable {
    let surname:    String
    let vorName:    String
    let FatherName: String
    let kurs:       String
    let specialty:  String
    let birthday:   String
    let email:      String
    let Faculty:    String
    let groop:      String
    let address:    String
    let form:       String
}

final class Login: Codable {
    let login: String?
    let password:  String?
    var deviceID: String?
    init(login: String, pass: String) {
        self.login = login
        self.deviceID = UIDevice.current.identifierForVendor?.uuidString
        self.password = pass
    }
}
final class Token: Codable {
    let token: String
    init(token: String){
        self.token = token
    }
}

