//
//  ApiRequ.swift
//  tableSettigins
//
//  Created by Владимир Лишаненко on 1/6/20.
//  Copyright © 2020 Li. All rights reserved.
//

import Foundation

enum APIError: Error {
    case responceProblem
    case decodingProblem
    case other
}


struct ApiRequest {
    let resourse: URL
    
    init(endpoint: String) {
        let resourseString = "http://93.125.18.58:3333/\(endpoint)"
        guard let resourse = URL(string: resourseString) else {fatalError()}
        self.resourse = resourse
    }
    func login(_ loginData:Login, completion: @escaping(Result<Token, APIError>) -> Void) {
        var request = URLRequest(url: resourse)
        request.httpMethod = "POST"
        let postString = "username=\(loginData.login!)&password=\(loginData.password!)&device_id=\(loginData.deviceID!)"
        request.httpBody = postString.data(using: .utf8)
        
        let session = URLSession.shared
        session.dataTask(with: request) { (data, response, error) in
            if let response = response {
                print(response)
            }
            
            guard let data = data else { return }
            
            do {
                let json = try JSONSerialization.jsonObject(with: data, options: [])
                print(json)
            } catch {
                print(error)
            }
        }.resume()
    }
}

