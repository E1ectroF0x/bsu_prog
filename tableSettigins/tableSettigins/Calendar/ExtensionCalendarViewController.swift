import UIKit

extension CalendarViewController: UITableViewDataSource, UITableViewDelegate {
    
    // MARK: lessonsView(UITableView) protocols methods
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return lessons.count
        
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 150
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "C2", for: indexPath) as! ScheduleTableViewCell
        
        cell.lessonTime.text = lessons[indexPath.row].getProperty(index: 0)
        cell.lessonType.text = lessons[indexPath.row].getProperty(index: 1)
        cell.lessonName.text = lessons[indexPath.row].getProperty(index: 2)
        cell.lessonLocation.text = lessons[indexPath.row].getProperty(index: 3)
        cell.teacherName.text = lessons[indexPath.row].getProperty(index: 4)
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
        let stroryboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = stroryboard.instantiateViewController(withIdentifier: "ScheduleTableViewController") as! ScheduleTableViewController
        vc.lessons = lessons
        self.present(vc, animated: true, completion: nil)
    }
}

extension CalendarViewController: UICollectionViewDelegate, UICollectionViewDataSource {
    
    // MARK: Calendar(UICollectionView) protocols methods
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {

        return DaysInMonth[month] + numberOfEmptyBoxes
//        switch direction {
//        case 0:
//            return DaysInMonth[month] + numberOfEmptyBoxes
//        case 1...:
//            return DaysInMonth[month] + nextNumberOfEmptyBox
//        case -1:
//            return DaysInMonth[month] + previosNumberOfEmptyBox
//        default:
//            fatalError()
//        }
    }
    
    
    //MARK: Changed Method
    
    func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
        day = indexPath.row + 1 - numberOfEmptyBoxes
        collectionView.reloadData()
        getLessons()
        scheduleView.reloadData()
    }
    
    func getLessons() {
        var dayString = String()
        dayString = "\(day)"
//        switch direction {
//        case 0:
//             dayString = "\(day - numberOfEmptyBoxes)"
//        case 1:
//             dayString = "\(day - nextNumberOfEmptyBox)"
//        case -1:
//             dayString = "\(day - previosNumberOfEmptyBox)"
//        default:
//            fatalError()
//        }
        
        let api = ApiRequest(endpoint: "api/get-shedule-day-list?date=\(year)-\(month + 1)-\(dayString)")
        print("\(year)-\(month + 1)-\(dayString)")
        api.getLesson { (result) in
            switch result {
            case.failure(let error) :
                print(error)
                self.lessons = [Lesson]()
            case.success(let lessons) :
                self.lessons = lessons
            }
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: IDForCalendar, for: indexPath) as! DateCollectionViewCell
        cell.backgroundColor = UIColor.clear
        cell.cellDateLabel.textColor = UIColor.black
        
        if cell.isHidden {
            cell.isHidden = false
        }
          cell.cellDateLabel.text = "\(indexPath.row + 1 - numberOfEmptyBoxes)"
//        switch direction {
//        case 0:
//            cell.cellDateLabel.text = "\(indexPath.row + 1 - numberOfEmptyBoxes)"
//        case 1:
//            cell.cellDateLabel.text = "\(indexPath.row + 1 - numberOfEmptyBoxes)"
//        case -1:
//            cell.cellDateLabel.text = "\(indexPath.row + 1 - numberOfEmptyBoxes)"
//        default:
//            fatalError()
//        }
        
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
        
        if  indexPath.row + 1 == day + numberOfEmptyBoxes{
            cell.backgroundColor = Constants.customBlue
            cell.layer.cornerRadius = cell.frame.width / 2
            cell.cellDateLabel.textColor = UIColor.white
        }
        return cell
    }
}
