//
//  JsonStruct.swift
//  tableSettigins
//
//  Created by Владимир Лишаненко on 1/6/20.
//  Copyright © 2020 Li. All rights reserved.
//

import Foundation
import UIKit

struct DataCalendar: Decodable {
    var data: [Lesson]
    var status: String
}

struct Lesson: Decodable {
    var time_start: String?
    var time_end: String?
    var audience: String?
    var building: String?
    var surname: String?
    var name: String?
    var fathername: String?
    var subject: String?
    var type: String?
    
    
    func getProperty(index : Int) -> String {
        switch index {
        case 0: return "\(self.time_start?.dropLast(3) ?? "") - \(self.time_end?.dropLast(3) ?? "")"
        case 1: return self.type!
        case 2: return self.subject!
        case 3:
            if let _ = self.audience {
                return "ул. \(self.building ?? ""), каб. \(self.audience ?? "")"
            } else if let _ = self.building {
                return "ул. \(self.building ?? "")"
            } else {
                return ""
            }
            
        case 4: return "\(self.surname!) \(self.name!) \(self.fathername!)"
            
        default:
            return "error"
        }
    }
}
    
    struct DataProfile: Decodable {
        let data: Profile
    }
    
    struct Profile: Decodable {
        let faculty:     String
        let speciality:   String
        let course:      String
        let group_number:String
        let form:        String
        let email:       String
        let address:     String
        let name:        String
        let surname:     String
        let fathername:  String
        var image : String
        
        func getProperty(index : Int) -> String {
            switch index {
            case 0: return self.faculty
            case 1: return self.speciality
            case 2: return "\(self.course), \(group_number)"
            case 3:
                if self.form == "1" {
                    return "Дневная, бюджет"
                } else {
                    return "Дневная, платная"
                }
            case 4: return "\(self.email)@bsu.by"
            case 5: return self.address
            default:
                return "error"
            }
        }
        
        func getImage() -> UIImage? {
            let base64 = self.image.replacingOccurrences(of: "data:image/jpeg;base64,", with: "")
            let imageData = Data(base64Encoded: base64, options: .ignoreUnknownCharacters)!
            let image = UIImage(data: imageData)
            return image
        }
        
        init() {
            self.image = String()
            self.name = String()
            self.surname =   String()
            self.fathername =  String()
            self.address =     String()
            self.email =       String()
            self.course =      String()
            self.form =        String()
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
    

