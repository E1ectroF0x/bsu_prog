//
//  CalendarViewController.swift
//  BSU
//
//  Created by Alexey Meleshkevich on 18/11/2019.
//  Copyright © 2019 Alexey Meleshkevich. All rights reserved.
//

import UIKit

class CalendarViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource {
    
    
    @IBOutlet weak var calendarView: UICollectionView!
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var moyeLabel: UILabel!
    
    let Months = ["January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"]
    let DaysOfMonth = ["Monday", "Tuesday", "Wednethday", "Thurstday", "Friday", "Saturday", "Sunday"]
    
    let DaysInMonth = [31,29,31,30,31,30,31,31,30,31,30,31]
    
    var currentMonth = String()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
//        currentMonth = Months[month]
            label.text = "\(currentMonth) \(year)"
//        
//        calendarView.delegate = self
//        calendarView.dataSource = self
        
    }
    
    @IBAction func nextButton(_ sender: Any) {
    }
    
    @IBAction func backButton(_ sender: Any) {
    }
    
    
}

extension CalendarViewController{
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "Calendar", for: indexPath) as! DateCollectionViewCell
        cell.backgroundColor = UIColor.clear
        cell.dateLabel.text = "\(indexPath.row + 1)"
        
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return DaysInMonth[month]
    }
    
}
