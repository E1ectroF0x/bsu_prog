//
//  ScheduleTableViewController.swift
//  tableSettigins
//
//  Created by Alexey Meleshkevich on 14.12.2019.
//  Copyright © 2019 Li. All rights reserved.
//

import Foundation
import UIKit

class ScheduleTableViewController: UITableViewController {
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 150
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "C3", for: indexPath) as! ScheduleTableViewControllerCell
        
        
        
        cell.timeCell.text = Constants.currentDayTime[indexPath.row]
        cell.typeCell.text = Constants.currentDayType[indexPath.row]
        cell.lessonCell.text = Constants.currentDayLesson[indexPath.row]
        cell.locationCell.text = Constants.currentDayLocation[indexPath.row]
        cell.teacherCell.text = Constants.currentDayName[indexPath.row]
        
        return cell
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return Constants.lessonsNumber
    }
}
