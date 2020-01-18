//
//  JsonStruct.swift
//  tableSettigins
//
//  Created by Владимир Лишаненко on 1/6/20.
//  Copyright © 2020 Li. All rights reserved.
//

import Foundation
import UIKit

struct DataProfile: Decodable {
    let data: Profile
}

struct Profile: Decodable {
    let name:        String
    let surname:     String
    let fathername:  String
    let address:     String
    let email:       String
    let course:      Int
    let form:        Int
    let birthdate:   String
    let group_number:String
    let speciality:   String
    let faculty:     String
    
    init() {
        self.name = String()
        self.surname =   String()
        self.fathername =  String()
        self.address =     String()
        self.email =       String()
        self.course =      Int()
        self.form =        Int()
        self.birthdate =   String()
        self.group_number = String()
        self.speciality =   String()
        self.faculty =      String()
    }
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
struct Token: Decodable {
    var token = String()
}

