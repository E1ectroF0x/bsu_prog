//
//  ExtensionCalendarViewController.swift
//  tableSettigins
//
//  Created by Li on 12/21/19.
//  Copyright © 2019 Li. All rights reserved.
//

import UIKit

import Foundation
import UIKit

extension CalendarViewController: UITableViewDataSource, UITableViewDelegate {
    
    // MARK: lessonsView(UITableView) protocols methods
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Constants.lessonsNumber
        
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 150
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "C2", for: indexPath) as! ScheduleTableViewCell
        
        cell.lessonTime.text = Constants.currentDayTime[indexPath.row]
        cell.lessonType.text = Constants.currentDayType[indexPath.row]
        cell.lessonName.text = Constants.currentDayLesson[indexPath.row]
        cell.lessonLocation.text = Constants.currentDayLocation[indexPath.row]
        cell.teacherName.text = Constants.currentDayName[indexPath.row]
        //
        //    if tapLogic == true {
        //    cell.lessonTime.text = Constants.currentDayTime[indexPath.row]
        //    cell.lessonType.text = Constants.otherDayType[indexPath.row]
        //    cell.lessonName.text = Constants.otherDayLesson[indexPath.row]
        //    cell.lessonLocation.text = Constants.otherDayLocation[indexPath.row]
        //    cell.teacherName.text = Constants.otherDayName[indexPath.row]
        //
        //    tableView.reloadData()
        //    }
        
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 0
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = UIView.init(frame: CGRect.init(x: 0, y: 0, width: 0, height: 0))
        
        return headerView
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    
    
}

extension CalendarViewController: UICollectionViewDelegate, UICollectionViewDataSource {
    
    // MARK: Calendar(UICollectionView) protocols methods
       
       func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
           switch direction {
           case 0:
               return DaysInMonth[month] + numberOfEmptyBoxes
           case 1...:
               return DaysInMonth[month] + nextNumberOfEmptyBox
           case -1:
               return DaysInMonth[month] + nextNumberOfEmptyBox
           default:
               fatalError()
           }
       }
       
//       func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
//           print("tapped at \(indexPath)")
//       }
       
       func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
           let cell = collectionView.dequeueReusableCell(withReuseIdentifier: IDForCalendar, for: indexPath) as! DateCollectionViewCell
           cell.backgroundColor = UIColor.clear
           cell.cellDateLabel.textColor = UIColor.black
           
           if cell.isHidden {
               cell.isHidden = false
           }
           
           switch direction {
           case 0:
               cell.cellDateLabel.text = "\(indexPath.row + 1 - numberOfEmptyBoxes)"
           case 1:
               cell.cellDateLabel.text = "\(indexPath.row + 1 - nextNumberOfEmptyBox)"
           case -1:
               cell.cellDateLabel.text = "\(indexPath.row + 1 - previosNumberOfEmptyBox)"
           default:
               fatalError()
           }
           
           if Int(cell.cellDateLabel.text!)! < 1 {
               cell.isHidden = true
           }
           
           switch indexPath.row {
           case 5,6,12,13,19,20,26,27,33,34:
               if Int(cell.cellDateLabel.text!)! > 0 {
                   cell.cellDateLabel.textColor = UIColor.lightGray
               }
           default:
               break
           }
           
           if currentMonth == Months[calendar.component(.month, from: date) - 1] && year == calendar.component(.year, from: date) && indexPath.row + 1 == day{
            cell.backgroundColor = Constants.customBlue
               cell.cellDateLabel.textColor = UIColor.white
           }
           return cell
       }
    
}
