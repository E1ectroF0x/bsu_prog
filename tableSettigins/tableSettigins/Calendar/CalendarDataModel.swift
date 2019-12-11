//
//  CalendarDataModel.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 18/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import Foundation

let data = Date()
let calendar = Calendar.current

let day = calendar.component(.day, from: data)
let weekday = calendar.component(.weekday, from: data)
let month = calendar.component(.month, from: data)
let year = calendar.component(.year, from: data)


