import UIKit

class CalendarViewController: UIViewController{
    
    
    //MARK: Property( Ebany rot chto oni znachat vapshe)
    var lessons = [Lesson]() {
        didSet {
            DispatchQueue.main.async {
                self.scheduleView.reloadData()
                self.scheduleView.isHidden = self.lessons.count == 0 ? true : false
            }
        }
    }
    let leftAndRightPaddings: CGFloat = 74.0
    let numberOfItems: CGFloat = 7.0
    public let IDForCalendar = "C1"
    
    @IBOutlet weak var calendar: UICollectionView!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var scheduleView: UITableView!
    
    @IBOutlet weak var weekdayStack: UIStackView!
    
    // MARK: Date for calendar
    let Months = ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"]
    var DaysInMonth = [31,28,31,30,31,30,31,31,30,31,30,31]
   
    
    
    var numberOfEmptyBoxes = 2    // The number of empty cells at the start of the current month
  //  var nextNumberOfEmptyBox = Int()
   // var previosNumberOfEmptyBox = Int()
   // var direction = 0                   // == 0 if current, == 1 if future, == -1 if in past
   // var positionIndex = 2
    var currentMonth = String()
    
    public var headerForLessonsTable = UITableViewHeaderFooterView()
    
    
    //MARK: Controller Lifecycle methods
    override func loadView() {
        super.loadView()
        DaysInMonth[1] = year % 4 == 0 ?29 :28
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        getNumberOfEmptyCellsInCollectionView(calendar: calendarForEblya, month: month, year: year)
       // GetStartDateDayPosition()
        getLessons()
        scheduleView.reloadData()
        currentMonth = Months[month]
        dateLabel.text = "\(currentMonth) " + "\(year)"
        layout()
    }
    
    //MARK: Methods for eblya with cells
    
    func getNumberOfEmptyCellsInCollectionView(calendar: Calendar, month: Int, year: Int )  {
        
        var dateComponents = DateComponents()
        dateComponents.day = 1
        dateComponents.month = month + 1
        dateComponents.year = year
        
        
        guard let firstDayInCurrentMonth = calendar.date(from: dateComponents) else { return }
        let weekday = calendar.component(.weekday, from: firstDayInCurrentMonth)
        
        switch weekday {
        case 2...7:
            numberOfEmptyBoxes = weekday - 2
        default:
            numberOfEmptyBoxes = 6
        }

    }
    
    
    @IBAction func back(_ sender: Any) {
        switch currentMonth {
        case "Январь":
            month = 11
            year -= 1
         //   direction = -1
            
            DaysInMonth[1] = year % 4 == 0 ?29 :28
            getNumberOfEmptyCellsInCollectionView(calendar: calendarForEblya, month: month, year: year)
                       
     // GetStartDateDayPosition()
//
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            calendar.reloadData()
        default:
            month -= 1
        //    direction = -1
             getNumberOfEmptyCellsInCollectionView(calendar: calendarForEblya, month: month, year: year)
           // GetStartDateDayPosition()
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            calendar.reloadData()
        }
        day = current_month_i == month && current_year_i == year ? current_day_i: -1
                   
    }
    
    
    @IBAction func next(_ sender: Any) {
        DaysInMonth[1] = year % 4 == 0 ?29 :28
        switch currentMonth {
        case "Декабрь":
            month = 0
            year += 1
        //    direction = 1
            
            getNumberOfEmptyCellsInCollectionView(calendar: calendarForEblya, month: month, year: year)
                       
          //  GetStartDateDayPosition()
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            calendar.reloadData()
        default:
      //      direction = 1
            month += 1
            getNumberOfEmptyCellsInCollectionView(calendar: calendarForEblya, month: month, year: year)
            
            //GetStartDateDayPosition()
            
           
            
            currentMonth = Months[month]
            dateLabel.text = "\(currentMonth) " + "\(year)"
            calendar.reloadData()
        }
         day = current_month_i == month && current_year_i == year ? current_day_i: -1
                   
    }
    
    
//    func GetStartDateDayPosition() {
//        switch direction {
//        case 0:
//            switch day {
//            case 1...7:
//                numberOfEmptyBoxes = weekday - day
//            case 8...14:
//                numberOfEmptyBoxes = weekday - day - 7
//            case 15...21:
//                numberOfEmptyBoxes = weekday - day - 14
//            case 22...28:
//                numberOfEmptyBoxes = weekday - day - 21
//            case 29...31:
//                numberOfEmptyBoxes = weekday - day - 28
//            default:
//                break
//            }
//            positionIndex = numberOfEmptyBoxes
//
//        case 1...:
//            nextNumberOfEmptyBox = (positionIndex + DaysInMonth[month])%7
//            positionIndex = nextNumberOfEmptyBox
//
//        case -1:
//            previosNumberOfEmptyBox = (7 - (DaysInMonth[month] - positionIndex) % 7)
//            if previosNumberOfEmptyBox == 7 {
//                previosNumberOfEmptyBox = 0
//            }
//            positionIndex = previosNumberOfEmptyBox
//        default:
//            fatalError()
//        }
//    }
    //MARK: methods for eblya with Layout
    func layout() {
        let layout: UICollectionViewFlowLayout = UICollectionViewFlowLayout()
        layout.sectionInset = UIEdgeInsets(top: 0, left: 5, bottom: 0, right: 5)
        let side = (view.frame.width - leftAndRightPaddings) / numberOfItems
        layout.itemSize = CGSize(width: side, height: side)
        calendar.collectionViewLayout = layout
        let constant = side * CGFloat((numberOfEmptyBoxes + 7 + DaysInMonth[month]) / 7).rounded(.up)
        calendar.translatesAutoresizingMaskIntoConstraints = false
        scheduleView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            calendar.topAnchor.constraint(equalTo: weekdayStack.topAnchor, constant: 30),
            calendar.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 0),
            calendar.trailingAnchor.constraint(equalTo: view.trailingAnchor, constant: 0),
            calendar.widthAnchor.constraint(equalToConstant: view.frame.width),
            calendar.heightAnchor.constraint(equalToConstant: constant + 100),
            scheduleView.bottomAnchor.constraint(equalTo: view.bottomAnchor, constant: 0),
            scheduleView.leadingAnchor.constraint(equalTo: view.leadingAnchor, constant: 0),
            scheduleView.widthAnchor.constraint(equalToConstant: view.frame.width),
            scheduleView.heightAnchor.constraint(equalToConstant: view.frame.height - constant - 300)])
                                    
    }
}
