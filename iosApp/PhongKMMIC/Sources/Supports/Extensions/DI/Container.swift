//
//  Container.swift
//  PhongKMMIC
//
//  Created by Phong Vo on 24/04/2023.
//  Copyright © 2023 Nimble. All rights reserved.
//

import Factory
import shared

extension Container {

    var splashViewModel: Factory<SplashViewModel> {
        Factory(self) { KoinApplication.inject(\.splashViewModel) }
    }

    var logInViewModel: Factory<LogInViewModel> {
        Factory(self) { KoinApplication.inject(\.logInViewModel) }
    }

    var homeViewModel: Factory<HomeViewModel> {
        Factory(self) { KoinApplication.inject(\.homeViewModel) }
    }

    var surveyDetailViewModel: Factory<SurveyDetailViewModel> {
        Factory(self) { KoinApplication.inject(\.surveyDetailViewModel) }
    }

    var surveyQuestionViewModel: Factory<SurveyQuestionViewModel> {
        Factory(self) { KoinApplication.inject(\.surveyQuestionViewModel) }
    }
}
