//
//  Constants.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 27/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import Foundation
import UIKit

struct Constants {
    static let USER_NAME_STRING: String = """
                                            Якушева
                                            Диана
                                            Анатольевна
                                          """
    
    static let SEGMENT_SET_ITEMS = [UIImage(named: "education"),
                                    UIImage(named: "money"),
                                    UIImage(named: "star")]
    
    static let SETTINGS_NAME_CELL = ["Уведомления", "Приватность", "Аккаунт",
                                     "Язык", "О приложении", "Выйти"]
    
    static let SETTINGS_ICONS_NAME_CELL = ["bell", "key", "user",
                                           "globe", "info", "exit"]
    
    static let USER_INFO_NAME_CELL = ["Факультет", "Специальность", "Курс, группа",
                                      "Форма обучения", "Почта", "Номер телефона",
                                      "Адресс проживания"]
    static let CREDIT_NAME_CELL = ["Оплата за обучение", "Пересдачи", "За общежитие", "Истроия платежей"]
    static let INFO_TABLE_INFO = ["РФиКТ", "Компьютерная безопастность", "2 курс, 7 группа", "Дневная, бюджет", "rct.truhov@bsu.by", "+375259612924", "Курчатова 8, Б84б"]
    
    
    static let customBlue = UIColor(red: 20.0 / 255.0, green: 78.0 / 255.0, blue: 157.0 / 255.0, alpha: 1.0)
    
    static let currentDayTime = ["9:00 - 10:20",
                                 "10:30 - 11:50",
                                 "12:00 - 13:20",
                                 "13:50 - 15:10",
                                 "15:20 - 16:40",
                                 "прокоповичтайм",]
    static let currentDayType = ["Практическое занятие", "Практическое занятие"]
    
    static let currentDayLesson = ["Теоритическая физика", "Методы мат.физики"]
    
    static let currentDayName = ["Жилко Виталий Владимирович", "Егоров Андрей Александрович"]
    
    static let currentDayLocation = ["каб.321","каб.613"]
    
    static let lessonsNumber = 2
    
    static let otherDayType = ["Практическое занятие", "Лабораторные занятия", "Лабораторные занятия"]
    
    static let otherDayLesson = ["Общая физика", "Общая физика", "Общая физика"]
    
    static let otherDayName = ["Трухан Сергей Васильевич", "Григорчук Елена Сергеевна", "Григорчук Елена Сергеевна"]
    
    static let otherDayLocation = ["каб.613","каб.513", "каб.513"]
    
    static let otherLessonsNumber = 3
    
    
    
    
}
