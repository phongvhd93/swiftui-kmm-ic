//
//  SurveyDetailView.swift
//  PhongKMMIC
//
//  Created by Phong Vo on 15/05/2023.
//  Copyright © 2023 Nimble. All rights reserved.
//

import shared
import SwiftUI

struct SurveyDetailView: View {

    @EnvironmentObject private var navigator: Navigator
    @ObservedObject private var viewModel: SurveyDetailCombineViewModel
    @State private var backgroundScale = 1.0

    var body: some View {
        ZStack {
            GeometryReader { geometryReader in
                Image.url(viewModel.backgroundImageUrl)
                    .resizable()
                    .scaledToFill()
                    .frame(width: geometryReader.size.width, height: geometryReader.size.height)
                    .scaleEffect(backgroundScale, anchor: .topTrailing)
                BlackGradientOverlay()
            }
            .ignoresSafeArea()

            contentView
        }
        .toolbar {
            ToolbarItem(placement: .navigationBarLeading) {
                Button {
                    didTapBackButton()
                } label: {
                    R.image.whiteLeftChevron.image
                }
            }
        }
        .navigationBarBackButtonHidden(true)
        .onLoad {
            viewModel.fetchSurvey()
            DispatchQueue.main.async {
                withAnimation(.easeIn(duration: 0.4)) {
                    backgroundScale = 1.4
                }
            }
        }
    }

    private var contentView: some View {
        VStack(alignment: .leading) {
            Text(viewModel.title)
                .font(.boldTitle)
                .foregroundColor(Color.white)

            Text(viewModel.description)
                .font(.regularBody)
                .foregroundColor(Color.white.opacity(0.7))
                .padding(.top, 16.0)

            Spacer()
            HStack {
                Spacer()
                Button {
                    // TODO: navigate user to survey questions view
                    print("Start survey was tapped")
                } label: {
                    Text(R.string.localizable.surveyDetailStartSurvey())
                        .frame(alignment: .center)
                        .font(.boldBody)
                        .padding(.horizontal, 21.0)
                }
                .frame(height: 56.0)
                .background(Color.white)
                .foregroundColor(Color.black)
                .cornerRadius(10.0)
            }
        }
        .padding(.top, 26.0)
        .padding(.horizontal, 20.0)
    }

    init(survey: SurveyUiModel) {
        viewModel = SurveyDetailCombineViewModel(survey: survey)
    }

    private func didTapBackButton() {
        withAnimation(.easeIn(duration: 0.4)) {
            backgroundScale = 1.0
        }
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.4) {
            self.navigator.goBackToRoot(isAnimated: false)
        }
    }
}
