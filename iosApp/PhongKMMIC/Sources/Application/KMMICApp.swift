//
//  KMMICApp.swift
//  PhongKMMIC
//
//  Created by Phong Vo on 11/04/2023.
//  Copyright © 2023 Nimble. All rights reserved.
//

import SwiftUI

@main
struct KMMICApp: App {

    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate

    var body: some Scene {
        WindowGroup {
            AppCoordinator()
                .preferredColorScheme(.dark)
        }
    }
}
