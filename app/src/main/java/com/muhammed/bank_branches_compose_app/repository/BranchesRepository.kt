package com.muhammed.bank_branches_compose_app.repository

import com.muhammed.bank_branches_compose_app.R
import com.muhammed.bank_branches_compose_app.data.Branch
import com.muhammed.bank_branches_compose_app.data.BranchType

object BranchesRepository {
        val branches = listOf(
            Branch(
                id = 1,
                name = "NBK Ahmadi Branch",
                type = BranchType.SERVICE_CENTER,
                address = "Building 800696، Dahiya Center, S 29 St, Al Ahmadi 60001",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/nbqvQzGChtnPpzdp6",
                imageUri = R.drawable.ahmadi
            ),
            Branch(
                id = 2,
                name = "KOC Ahmadi Branch",
                type = BranchType.ATM,
                address = "KOC Ahmadi Park, 7th Ave, T415 60000, Kuwait",
                phone = "1801801",
                hours = "Open 24 Hours",
                location = "https://maps.app.goo.gl/4QU5TJZurULKVhPq8",
                imageUri = null
            ),
            Branch(
                id = 3,
                name = "NBK Al-Hajraf",
                type = BranchType.SERVICE_CENTER,
                address = "Al Hajraf Building, Street 4 4, Al Jahra 00024, Kuwait",
                phone = "1801801",
                hours = "9:00 AM - 1:00 PM & 5:00 PM - 7 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/9dSe19HifxoDC6KS6",
                imageUri = R.drawable.hajraf
            ),
            Branch(
                id = 4,
                name = "NBK HQ",
                type = BranchType.MAIN,
                address = "Al-Shuhada St, Kuwait City 25843, Kuwait",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/NDofbT4SxUbc22mM9",
                imageUri = R.drawable.hq
            ),
            Branch(
                id = 5,
                name = "NBK Dahiya Branch",
                type = BranchType.SERVICE_CENTER,
                address = "Dahiya Center, 111 St, Jabriya 46301, Kuwait",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/QeQsPXZ7wQQD76yT8",
                imageUri = R.drawable.dahiya
            ),
            Branch(
                id = 6,
                name = "NBK Trolley Jaber Al Ahmad",
                type = BranchType.ATM,
                address = "Trolley KNPC, 633 Street, 136 T386, Jaber Al Ahmad 91710",
                phone = "1801801",
                hours = "Open 24 Hours",
                location = "https://maps.app.goo.gl/uon4xV6GZmEiMDDA9",
                imageUri = null
            ),
            Branch(
                id = 7,
                name = "NBK The Avenues Mall Branch",
                type = BranchType.SERVICE_CENTER,
                address = "The Avenues Mall, Ghazali St, Plaza 70071",
                phone = "1801801",
                hours = "10:00 AM - 10:00 PM | Saturday - Thursday",
                location = "https://maps.app.goo.gl/N93f5TKi9hyqaynZ7",
                imageUri = R.drawable.avenues
            ),
            Branch(
                id = 8,
                name = "NBK Farwaniyah Branch",
                type = BranchType.SERVICE_CENTER,
                address = "90 St, 85601",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/VdgcbKk4x79cSYdFA",
                imageUri = R.drawable.farwaniyah
            ),
            Branch(
                id = 9,
                name = "NBK Free Trade Zone",
                type = BranchType.ATM,
                address = "KNPC Petrol Station, Kuwait Free Trade Zone",
                phone = "1801801",
                hours = "Open 24 Hours",
                location = "https://maps.app.goo.gl/6oiEEUBCNEzh8Jj77",
                imageUri = null
            ),
            Branch(
                id = 10,
                name = "NBK Jahra Branch",
                type = BranchType.SERVICE_CENTER,
                address = "Street 2 Jahra, Block 4, The Managerial and Commercial Centre AlJahara",
                phone = "1801801",
                hours = "9:00 AM - 1 PM & 5:00 PM - 7:00 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/mjw4QzxpgJHL7Bmw9",
                imageUri = R.drawable.jahra
            )
        )
    }