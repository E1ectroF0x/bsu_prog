//
//  CalendarViewController.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 18/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

import UIKit

class CalendarViewController: UIViewController{
    
    
    
    @IBOutlet weak var Calendar: UICollectionView!
    public let IDForCalendar = "C1"
    
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var scheduleView: UITableView!
    
    
    // MARK: Date for calendar
    let Months = ["Январь",
                  "Февраль",
                  "Март",
                  "Апрель",
                  "Май",
                  "Июнь",
                  "Июль",
                  "Август",
                  "Сентябрь",
                  "Октябрь",
                  "Ноябрь",
                  "Декабрь"]
    let DaysOfMonth = ["Monday", "Thuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    var DaysInMonth = [31,28,31,30,31,30,31,31,30,31,30,31]
    // Calendar logic
    var numberOfEmptyBoxes = Int()      // The number of empty cells at the start of the current month
    var nextNumberOfEmptyBox = Int()
    var previosNumberOfEmptyBox = Int()
    var direction = 0                   // == 0 if current, == 1 if future, == -1 if in past
    var positionIndex = 0
    var LeapYearCounter = 2             // == 2 (february day == 29 || 28)
    var currentMonth = String()
    
    var tapLogic = false
    
    // MARK: Date for schedule
    
    //    let currentDaySchedule = ["time": ["9:00 - 10:20", "10:30 - 11:50"],
    //                              "type": ["Практическое занятие", "Практическое занятие"],
    //                              "lesson":["Теоритическая физика", "Методы мат.физики"],
    //                              "name": ["Жилко Виталий Владимирович", "Егоров Андрей Александрович"],
    //                              "location": ["каб.321","каб.613"] ]
    
    
    public var headerForLessonsTable = UITableViewHeaderFooterView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        currentMonth = Months[month]
        dateLabel.text = "\(currentMonth) " + "\(year)"
        
        //         Calendar.addGestureRecognizer(UITapGestureRecognizer(target: self, action: #selector(tap)))
        
        // Tap set
//        let tap = UITapGestureRecognizer(target: self, action: #selector(cellTap(_:)))
//        tap.numberOfTapsRequired = 1
//        tap.numberOfTouchesRequired = 1
//        tap.delegate = self
//        Calendar.addGestureRecognizer(tap)
            
    }
    
//    @objc func cellTap(_ sender: UITapGestureRecognizer){
//        let point = sender.location(in: Calendar)
//
//        if let indexPath = Calendar?.indexPathForItem(at: point) {
//            print(#function, indexPath)
//        }
//    }
    
    @IBAction func back(_ sender: Any) {
        switch currentMonth {
        case "Январь":
            month = 11
            year -= 1
            direction = -1
            
            if LeapYearCounter > 0 {
                LeapYearCounter -= 1
            }
            
            if LeapYearCounter == 0 {
                DaysInMonth[1] = 29
                LeapYearCounter = 4
            } else {
                DaysInMonth[1] = 28
            }
            
            GetStartDateDayPosition()
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            Calendar.reloadData()
        default:
            month -= 1
            direction = -1
            
            GetStartDateDayPosition()
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            Calendar.reloadData()
        }
    }
    
    
    @IBAction func next(_ sender: Any) {
        switch currentMonth {
        case "Декабрь":
            month = 0
            year += 1
            direction = 1
            
            if LeapYearCounter < 5 {
                LeapYearCounter += 1
            }
            
            if LeapYearCounter == 4 {
                DaysInMonth[1] = 29
            }
            
            if LeapYearCounter == 5 {
                LeapYearCounter = 1
                DaysInMonth[1] = 28
            }
            
            GetStartDateDayPosition()
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            Calendar.reloadData()
        default:
            direction = 1
            
            GetStartDateDayPosition()
            
            month += 1
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            Calendar.reloadData()
        }
    }
    
    
    func GetStartDateDayPosition() {
        switch direction {
        case 0:
            switch day {
            case 1...7:
                numberOfEmptyBoxes = weekday - day
            case 8...14:
                numberOfEmptyBoxes = weekday - day - 7
            case 15...21:
                numberOfEmptyBoxes = weekday - day - 14
            case 22...28:
                numberOfEmptyBoxes = weekday - day - 21
            case 29...31:
                numberOfEmptyBoxes = weekday - day - 28
            default:
                break
            }
            positionIndex = numberOfEmptyBoxes
            
        case 1...:
            nextNumberOfEmptyBox = (positionIndex + DaysInMonth[month])%7
            positionIndex = nextNumberOfEmptyBox
            
        case -1:
            previosNumberOfEmptyBox = (7 - (DaysInMonth[month] - positionIndex)%7)
            if previosNumberOfEmptyBox == 7 {
                previosNumberOfEmptyBox = 0
            }
            positionIndex = previosNumberOfEmptyBox
        default:
            fatalError()
        }
    }
    
    //    @objc func cellTap(_ sender: DateCollectionViewCell){
    //        if sender = DateCollectionViewCell{
    //        print("good morning")
    //        }
    //    }
    
    
    
    
    
//    func gestureRecognizer(_ gestureRecognizer: UIGestureRecognizer, shouldReceive touch: UITouch) -> Bool {
//        let point = touch.location(in: Calendar)
//        if let indexPath = Calendar?.indexPathForItem(at: point),
//            let cell = Calendar?.cellForItem(at: indexPath) {
//            return touch.location(in: cell).y > 50
//        }
//        
//        return false
//    }
}


