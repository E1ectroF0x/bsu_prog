//
//  CalendarDataModel.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 18/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import Foundation

let date = Date()
let calendar = Calendar.current

var day = calendar.component(.day, from: date)
var weekday = calendar.component(.weekday, from: date)
var month = calendar.component(.month, from: date) - 1
var year = calendar.component(.year, from: date)

let current_day_i = calendar.component(.day, from: date)
let current_month_i = calendar.component(.month, from: date) - 1
var current_year_i = calendar.component(.year, from: date)



