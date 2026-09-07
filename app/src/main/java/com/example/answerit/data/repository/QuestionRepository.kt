package com.example.answerit.data.repository

import com.example.answerit.data.model.Category
import com.example.answerit.data.model.Difficulty
import com.example.answerit.data.model.Language
import com.example.answerit.data.model.Question

object QuestionRepository {

    data class LocalizedQuestionData(
        val id: Int,
        val difficulty: Difficulty,
        val category: Category,
        val correctAnswer: Int,
        val trQuestion: String,
        val trOptions: List<String>,
        val enQuestion: String,
        val enOptions: List<String>
    )

    private val prizeSteps = listOf(
        100, 200, 300, 500, 1_000,
        2_000, 4_000, 8_000, 16_000, 32_000,
        64_000, 125_000, 250_000, 500_000, 1_000_000
    )

    private val rawQuestions: List<LocalizedQuestionData> = listOf(
        LocalizedQuestionData(
            id = 1,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Türkiye'nin başkenti neresidir?",
            trOptions = listOf("İstanbul", "Ankara", "İzmir", "Bursa"),
            enQuestion = "What is the capital of Turkey?",
            enOptions = listOf("Istanbul", "Ankara", "Izmir", "Bursa")
        ),
        LocalizedQuestionData(
            id = 2,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Güneş'e en yakın gezegen hangisidir?",
            trOptions = listOf("Venüs", "Merkür", "Mars", "Dünya"),
            enQuestion = "Which planet is closest to the Sun?",
            enOptions = listOf("Venus", "Mercury", "Mars", "Earth")
        ),
        LocalizedQuestionData(
            id = 3,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "İstanbul hangi yılda fethedilmiştir?",
            trOptions = listOf("1451", "1452", "1453", "1454"),
            enQuestion = "In which year was Istanbul conquered?",
            enOptions = listOf("1451", "1452", "1453", "1454")
        ),
        LocalizedQuestionData(
            id = 4,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Periyodik tabloda 'Fe' simgesi hangi elemente aittir?",
            trOptions = listOf("Flor", "Demir", "Fosfor", "Fermiyum"),
            enQuestion = "Which element is represented by 'Fe'?",
            enOptions = listOf("Fluorine", "Iron", "Phosphorus", "Fermium")
        ),
        LocalizedQuestionData(
            id = 5,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Türkiye'nin en yüksek dağı hangisidir?",
            trOptions = listOf("Erciyes", "Ağrı Dağı", "Uludağ", "Kaçkar"),
            enQuestion = "What is the highest mountain in Turkey?",
            enOptions = listOf("Erciyes", "Mount Ararat", "Uludag", "Kackar")
        ),
        LocalizedQuestionData(
            id = 6,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "İnsan vücudundaki en büyük organ hangisidir?",
            trOptions = listOf("Kalp", "Beyin", "Karaciğer", "Deri"),
            enQuestion = "What is the largest organ in the human body?",
            enOptions = listOf("Heart", "Brain", "Liver", "Skin")
        ),
        LocalizedQuestionData(
            id = 7,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Fransa'nın başkenti neresidir?",
            trOptions = listOf("Paris", "Lyon", "Marsilya", "Nice"),
            enQuestion = "What is the capital of France?",
            enOptions = listOf("Paris", "Lyon", "Marseille", "Nice")
        ),
        LocalizedQuestionData(
            id = 8,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 2,
            trQuestion = "Bir haftada kaç gün vardır?",
            trOptions = listOf("5", "6", "7", "8"),
            enQuestion = "How many days are in a week?",
            enOptions = listOf("5", "6", "7", "8")
        ),
        LocalizedQuestionData(
            id = 9,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Suyun kimyasal formülü nedir?",
            trOptions = listOf("H2O", "CO2", "NaCl", "O2"),
            enQuestion = "What is the chemical formula of water?",
            enOptions = listOf("H2O", "CO2", "NaCl", "O2")
        ),
        LocalizedQuestionData(
            id = 10,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "Futbolda bir takım sahada kaç kişiyle mücadele eder?",
            trOptions = listOf("10", "11", "12", "9"),
            enQuestion = "How many players does a football team have on the pitch?",
            enOptions = listOf("10", "11", "12", "9")
        ),
        LocalizedQuestionData(
            id = 11,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "İtalya'nın başkenti neresidir?",
            trOptions = listOf("Milano", "Venedik", "Roma", "Napoli"),
            enQuestion = "What is the capital of Italy?",
            enOptions = listOf("Milan", "Venice", "Rome", "Naples")
        ),
        LocalizedQuestionData(
            id = 12,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Hangi gezegen 'Kızıl Gezegen' olarak adlandırılır?",
            trOptions = listOf("Venüs", "Mars", "Jüpiter", "Satürn"),
            enQuestion = "Which planet is known as the 'Red Planet'?",
            enOptions = listOf("Venus", "Mars", "Jupiter", "Saturn")
        ),
        LocalizedQuestionData(
            id = 13,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 3,
            trQuestion = "Trafik ışıklarında 'Geç' anlamına gelen renk hangisidir?",
            trOptions = listOf("Kırmızı", "Sarı", "Mavi", "Yeşil"),
            enQuestion = "Which color means 'Go' on traffic lights?",
            enOptions = listOf("Red", "Yellow", "Blue", "Green")
        ),
        LocalizedQuestionData(
            id = 14,
            difficulty = Difficulty.EASY,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Mona Lisa tablosu hangi ünlü ressama aittir?",
            trOptions = listOf("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Salvador Dali"),
            enQuestion = "Who painted the Mona Lisa?",
            enOptions = listOf("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Salvador Dali")
        ),
        LocalizedQuestionData(
            id = 15,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Almanya'nın başkenti neresidir?",
            trOptions = listOf("Münih", "Berlin", "Frankfurt", "Hamburg"),
            enQuestion = "What is the capital of Germany?",
            enOptions = listOf("Munich", "Berlin", "Frankfurt", "Hamburg")
        ),
        LocalizedQuestionData(
            id = 16,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Dünya'nın doğal uydusu nedir?",
            trOptions = listOf("Güneş", "Mars", "Ay", "Venüs"),
            enQuestion = "What is the natural satellite of Earth?",
            enOptions = listOf("Sun", "Mars", "Moon", "Venus")
        ),
        LocalizedQuestionData(
            id = 17,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Bir yılda kaç ay vardır?",
            trOptions = listOf("10", "12", "14", "11"),
            enQuestion = "How many months are there in a year?",
            enOptions = listOf("10", "12", "14", "11")
        ),
        LocalizedQuestionData(
            id = 18,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 3,
            trQuestion = "Türkiye Cumhuriyeti hangi yılda kurulmuştur?",
            trOptions = listOf("1920", "1921", "1922", "1923"),
            enQuestion = "In which year was the Republic of Turkey founded?",
            enOptions = listOf("1920", "1921", "1922", "1923")
        ),
        LocalizedQuestionData(
            id = 19,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Basketbolda standart bir maç kaç periyottan oluşur?",
            trOptions = listOf("4", "2", "3", "5"),
            enQuestion = "How many quarters are in a standard basketball game?",
            enOptions = listOf("4", "2", "3", "5")
        ),
        LocalizedQuestionData(
            id = 20,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Bitkilerin besin üretmek için güneş ışığını kullanma sürecine ne denir?",
            trOptions = listOf("Solunum", "Fotosentez", "Fermantasyon", "Sindirim"),
            enQuestion = "What is the process plants use to make food from sunlight?",
            enOptions = listOf("Respiration", "Photosynthesis", "Fermentation", "Digestion")
        ),
        LocalizedQuestionData(
            id = 21,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "İspanya'nın başkenti neresidir?",
            trOptions = listOf("Madrid", "Barselona", "Sevilla", "Valencia"),
            enQuestion = "What is the capital of Spain?",
            enOptions = listOf("Madrid", "Barcelona", "Seville", "Valencia")
        ),
        LocalizedQuestionData(
            id = 22,
            difficulty = Difficulty.EASY,
            category = Category.CINEMA_POP,
            correctAnswer = 2,
            trQuestion = "Harry Potter serisinin yazarı kimdir?",
            trOptions = listOf("Stephen King", "J.R.R. Tolkien", "J.K. Rowling", "George R.R. Martin"),
            enQuestion = "Who wrote the Harry Potter book series?",
            enOptions = listOf("Stephen King", "J.R.R. Tolkien", "J.K. Rowling", "George R.R. Martin")
        ),
        LocalizedQuestionData(
            id = 23,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "iPhone akıllı telefonunu üreten teknoloji şirketi hangisidir?",
            trOptions = listOf("Google", "Apple", "Microsoft", "Samsung"),
            enQuestion = "Which company produces the iPhone?",
            enOptions = listOf("Google", "Apple", "Microsoft", "Samsung")
        ),
        LocalizedQuestionData(
            id = 24,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Periyodik tabloda 'O' simgesi hangi elementi temsil eder?",
            trOptions = listOf("Oksijen", "Altın", "Gümüş", "Osmiyum"),
            enQuestion = "Which element does 'O' represent in the periodic table?",
            enOptions = listOf("Oxygen", "Gold", "Silver", "Osmium")
        ),
        LocalizedQuestionData(
            id = 25,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "İngiltere'nin başkenti neresidir?",
            trOptions = listOf("Manchester", "Liverpool", "Londra", "Birmingham"),
            enQuestion = "What is the capital of the United Kingdom?",
            enOptions = listOf("Manchester", "Liverpool", "London", "Birmingham")
        ),
        LocalizedQuestionData(
            id = 26,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Bir saat kaç dakikadan oluşur?",
            trOptions = listOf("30", "60", "90", "100"),
            enQuestion = "How many minutes are in one hour?",
            enOptions = listOf("30", "60", "90", "100")
        ),
        LocalizedQuestionData(
            id = 27,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "Olimpiyat Oyunları kural olarak kaç yılda bir düzenlenir?",
            trOptions = listOf("2", "4", "5", "3"),
            enQuestion = "How often are the Olympic Games held?",
            enOptions = listOf("2", "4", "5", "3")
        ),
        LocalizedQuestionData(
            id = 28,
            difficulty = Difficulty.EASY,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "İstiklal Marşı'mızın şairi kimdir?",
            trOptions = listOf("Mehmet Akif Ersoy", "Namık Kemal", "Nazım Hikmet", "Yahya Kemal Beyatlı"),
            enQuestion = "Who is the poet of the Turkish National Anthem?",
            enOptions = listOf("Mehmet Akif Ersoy", "Namik Kemal", "Nazim Hikmet", "Yahya Kemal Beyatli")
        ),
        LocalizedQuestionData(
            id = 29,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Bal arılarının ürettiği tatlı ve şifalı besin nedir?",
            trOptions = listOf("Süt", "Reçel", "Bal", "Pekmez"),
            enQuestion = "What sweet food do honey bees produce?",
            enOptions = listOf("Milk", "Jam", "Honey", "Molasses")
        ),
        LocalizedQuestionData(
            id = 30,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en popüler video paylaşım platformu hangisidir?",
            trOptions = listOf("Spotify", "YouTube", "Twitter", "LinkedIn"),
            enQuestion = "What is the world's most popular video-sharing platform?",
            enOptions = listOf("Spotify", "YouTube", "Twitter", "LinkedIn")
        ),
        LocalizedQuestionData(
            id = 31,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 3,
            trQuestion = "Japonya'nın başkenti neresidir?",
            trOptions = listOf("Kyoto", "Osaka", "Hiroşima", "Tokyo"),
            enQuestion = "What is the capital of Japan?",
            enOptions = listOf("Kyoto", "Osaka", "Hiroshima", "Tokyo")
        ),
        LocalizedQuestionData(
            id = 32,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Kutup ayıları nerede yaşar?",
            trOptions = listOf("Güney Kutbu", "Kuzey Kutbu", "Afrika Çölleri", "Avustralya"),
            enQuestion = "Where do polar bears naturally live?",
            enOptions = listOf("South Pole", "North Pole", "African Deserts", "Australia")
        ),
        LocalizedQuestionData(
            id = 33,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 0,
            trQuestion = "Satranç tahtasında toplam kaç kare vardır?",
            trOptions = listOf("64", "32", "100", "81"),
            enQuestion = "How many squares are on a standard chessboard?",
            enOptions = listOf("64", "32", "100", "81")
        ),
        LocalizedQuestionData(
            id = 34,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Türkiye Büyük Millet Meclisi hangi yılda açılmıştır?",
            trOptions = listOf("1919", "1920", "1923", "1924"),
            enQuestion = "In which year was the Grand National Assembly of Turkey opened?",
            enOptions = listOf("1919", "1920", "1923", "1924")
        ),
        LocalizedQuestionData(
            id = 35,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Mısır piramitleri hangi kıtadadır?",
            trOptions = listOf("Afrika", "Asya", "Avrupa", "Amerika"),
            enQuestion = "On which continent are the Egyptian pyramids located?",
            enOptions = listOf("Africa", "Asia", "Europe", "America")
        ),
        LocalizedQuestionData(
            id = 36,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Hangi hayvan 'Ormanın Kralı' olarak anılır?",
            trOptions = listOf("Kaplan", "Fil", "Aslan", "Kurt"),
            enQuestion = "Which animal is traditionally known as the 'King of the Jungle'?",
            enOptions = listOf("Tiger", "Elephant", "Lion", "Wolf")
        ),
        LocalizedQuestionData(
            id = 37,
            difficulty = Difficulty.EASY,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Yıldızlı Gece (The Starry Night) tablosunu hangi ressam yapmıştır?",
            trOptions = listOf("Claude Monet", "Vincent van Gogh", "Pablo Picasso", "Edvard Munch"),
            enQuestion = "Who painted The Starry Night?",
            enOptions = listOf("Claude Monet", "Vincent van Gogh", "Pablo Picasso", "Edvard Munch")
        ),
        LocalizedQuestionData(
            id = 38,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "Windows işletim sistemini geliştiren şirket hangisidir?",
            trOptions = listOf("Microsoft", "Apple", "Google", "Oracle"),
            enQuestion = "Which company developed the Windows operating system?",
            enOptions = listOf("Microsoft", "Apple", "Google", "Oracle")
        ),
        LocalizedQuestionData(
            id = 39,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Teniste puanlama hangi sayı ile başlar?",
            trOptions = listOf("1", "10", "15", "5"),
            enQuestion = "What is the first score call in tennis?",
            enOptions = listOf("1", "10", "15", "5")
        ),
        LocalizedQuestionData(
            id = 40,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Rusya'nın başkenti neresidir?",
            trOptions = listOf("St. Petersburg", "Moskova", "Kazan", "Novosibirsk"),
            enQuestion = "What is the capital of Russia?",
            enOptions = listOf("St. Petersburg", "Moscow", "Kazan", "Novosibirsk")
        ),
        LocalizedQuestionData(
            id = 41,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 0,
            trQuestion = "Bir üçgenin iç açıları toplamı kaç derecedir?",
            trOptions = listOf("180", "360", "90", "270"),
            enQuestion = "What is the sum of angles in a triangle?",
            enOptions = listOf("180 degrees", "360 degrees", "90 degrees", "270 degrees")
        ),
        LocalizedQuestionData(
            id = 42,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "Işık hızının yaklaşık değeri saniyede kaç kilometredir?",
            trOptions = listOf("3.000", "30.000", "100.000", "300.000"),
            enQuestion = "What is the approximate speed of light in km/s?",
            enOptions = listOf("3,000", "30,000", "100,000", "300,000")
        ),
        LocalizedQuestionData(
            id = 43,
            difficulty = Difficulty.EASY,
            category = Category.CINEMA_POP,
            correctAnswer = 1,
            trQuestion = "Yüzüklerin Efendisi serisinde Tek Yüzük'ü yok etmek için yola çıkan hobbit kimdir?",
            trOptions = listOf("Sam", "Frodo", "Pippin", "Merry"),
            enQuestion = "Which hobbit is tasked with destroying the One Ring in Lord of the Rings?",
            enOptions = listOf("Sam", "Frodo", "Pippin", "Merry")
        ),
        LocalizedQuestionData(
            id = 44,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Osmanlı Devleti'nin kurucusu kimdir?",
            trOptions = listOf("Osman Gazi", "Orhan Gazi", "Ertuğrul Gazi", "Fatih Sultan Mehmet"),
            enQuestion = "Who was the founder of the Ottoman Empire?",
            enOptions = listOf("Osman I", "Orhan I", "Ertugrul", "Mehmed II")
        ),
        LocalizedQuestionData(
            id = 45,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Yunanistan'ın başkenti neresidir?",
            trOptions = listOf("Selanik", "Girit", "Atina", "Rodos"),
            enQuestion = "What is the capital of Greece?",
            enOptions = listOf("Thessaloniki", "Crete", "Athens", "Rhodes")
        ),
        LocalizedQuestionData(
            id = 46,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Normal şartlarda saf su kaç santigrat derecede kaynar?",
            trOptions = listOf("100", "90", "120", "80"),
            enQuestion = "At what temperature in Celsius does pure water boil at sea level?",
            enOptions = listOf("100", "90", "120", "80")
        ),
        LocalizedQuestionData(
            id = 47,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "Voleybolda bir takım sahada kaç oyuncuyla yer alır?",
            trOptions = listOf("5", "6", "7", "8"),
            enQuestion = "How many players are on the court for a volleyball team?",
            enOptions = listOf("5", "6", "7", "8")
        ),
        LocalizedQuestionData(
            id = 48,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 2,
            trQuestion = "İnternet sitelerinin başında sıkça görülen 'WWW' neyin kısaltmasıdır?",
            trOptions = listOf("World Wide Wire", "Web Wide World", "World Wide Web", "World Web Wide"),
            enQuestion = "What does 'WWW' stand for?",
            enOptions = listOf("World Wide Wire", "Web Wide World", "World Wide Web", "World Web Wide")
        ),
        LocalizedQuestionData(
            id = 49,
            difficulty = Difficulty.EASY,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Romeo ve Juliet adlı eserin yazarı kimdir?",
            trOptions = listOf("William Shakespeare", "Charles Dickens", "Victor Hugo", "Dostoyevski"),
            enQuestion = "Who wrote Romeo and Juliet?",
            enOptions = listOf("William Shakespeare", "Charles Dickens", "Victor Hugo", "Dostoevsky")
        ),
        LocalizedQuestionData(
            id = 50,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Çin'in başkenti neresidir?",
            trOptions = listOf("Şanghay", "Pekin", "Hong Kong", "Guangzhou"),
            enQuestion = "What is the capital of China?",
            enOptions = listOf("Shanghai", "Beijing", "Hong Kong", "Guangzhou")
        ),
        LocalizedQuestionData(
            id = 51,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 2,
            trQuestion = "Gökkuşağında kaç ana renk bulunur?",
            trOptions = listOf("5", "6", "7", "8"),
            enQuestion = "How many colors are in a rainbow?",
            enOptions = listOf("5", "6", "7", "8")
        ),
        LocalizedQuestionData(
            id = 52,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Hangisi memeli bir hayvandır?",
            trOptions = listOf("Köpekbalığı", "Balina", "Penguen", "Timsah"),
            enQuestion = "Which of the following is a mammal?",
            enOptions = listOf("Shark", "Whale", "Penguin", "Crocodile")
        ),
        LocalizedQuestionData(
            id = 53,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Mustafa Kemal Atatürk hangi şehirde doğmuştur?",
            trOptions = listOf("Selanik", "İstanbul", "Manastır", "Ankara"),
            enQuestion = "In which city was Mustafa Kemal Ataturk born?",
            enOptions = listOf("Thessaloniki", "Istanbul", "Bitola", "Ankara")
        ),
        LocalizedQuestionData(
            id = 54,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 3,
            trQuestion = "Dünyanın en uzun nehri hangisi kabul edilir?",
            trOptions = listOf("Amazon", "Mississippi", "Tuna", "Nil"),
            enQuestion = "Which river is widely considered the longest in the world?",
            enOptions = listOf("Amazon", "Mississippi", "Danube", "Nile")
        ),
        LocalizedQuestionData(
            id = 55,
            difficulty = Difficulty.EASY,
            category = Category.CINEMA_POP,
            correctAnswer = 1,
            trQuestion = "Titanik filminin ünlü yönetmeni kimdir?",
            trOptions = listOf("Steven Spielberg", "James Cameron", "Christopher Nolan", "Quentin Tarantino"),
            enQuestion = "Who directed the movie Titanic?",
            enOptions = listOf("Steven Spielberg", "James Cameron", "Christopher Nolan", "Quentin Tarantino")
        ),
        LocalizedQuestionData(
            id = 56,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "İnsan vücudunda kanı vücuda pompalayan organ hangisidir?",
            trOptions = listOf("Kalp", "Akciğer", "Mide", "Böbrek"),
            enQuestion = "Which organ pumps blood throughout the human body?",
            enOptions = listOf("Heart", "Lungs", "Stomach", "Kidneys")
        ),
        LocalizedQuestionData(
            id = 57,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Sosyal medya devi Facebook'un kurucusu kimdir?",
            trOptions = listOf("Elon Musk", "Mark Zuckerberg", "Bill Gates", "Jeff Bezos"),
            enQuestion = "Who co-founded Facebook?",
            enOptions = listOf("Elon Musk", "Mark Zuckerberg", "Bill Gates", "Jeff Bezos")
        ),
        LocalizedQuestionData(
            id = 58,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Maraton koşusunun standart mesafesi yaklaşık kaç kilometredir?",
            trOptions = listOf("21 km", "30 km", "42 km", "50 km"),
            enQuestion = "What is the standard distance of a marathon race?",
            enOptions = listOf("21 km", "30 km", "42 km", "50 km")
        ),
        LocalizedQuestionData(
            id = 59,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Portekiz'in başkenti neresidir?",
            trOptions = listOf("Lizbon", "Porto", "Coimbra", "Faro"),
            enQuestion = "What is the capital of Portugal?",
            enOptions = listOf("Lisbon", "Porto", "Coimbra", "Faro")
        ),
        LocalizedQuestionData(
            id = 60,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Bir düzine kaç adettir?",
            trOptions = listOf("10", "12", "15", "20"),
            enQuestion = "How many items are in a dozen?",
            enOptions = listOf("10", "12", "15", "20")
        ),
        LocalizedQuestionData(
            id = 61,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Hangi gezegen halkalarıyla ünlüdür?",
            trOptions = listOf("Mars", "Venüs", "Satürn", "Merkür"),
            enQuestion = "Which planet is famous for its prominent ring system?",
            enOptions = listOf("Mars", "Venus", "Saturn", "Mercury")
        ),
        LocalizedQuestionData(
            id = 62,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Cumhuriyet Bayramı her yıl hangi gün kutlanır?",
            trOptions = listOf("23 Nisan", "29 Ekim", "19 Mayıs", "30 Ağustos"),
            enQuestion = "On which date is Republic Day celebrated in Turkey?",
            enOptions = listOf("April 23", "October 29", "May 19", "August 30")
        ),
        LocalizedQuestionData(
            id = 63,
            difficulty = Difficulty.EASY,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Küçük Prens (Le Petit Prince) adlı eserin yazarı kimdir?",
            trOptions = listOf("Antoine de Saint-Exupéry", "Jules Verne", "Albert Camus", "Jean-Paul Sartre"),
            enQuestion = "Who wrote The Little Prince?",
            enOptions = listOf("Antoine de Saint-Exupéry", "Jules Verne", "Albert Camus", "Jean-Paul Sartre")
        ),
        LocalizedQuestionData(
            id = 64,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Hollanda'nın başkenti neresidir?",
            trOptions = listOf("Rotterdam", "Amsterdam", "Lahey", "Utrecht"),
            enQuestion = "What is the capital of the Netherlands?",
            enOptions = listOf("Rotterdam", "Amsterdam", "The Hague", "Utrecht")
        ),
        LocalizedQuestionData(
            id = 65,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "İnsan vücudunda kaç adet kemik bulunur (yetişkinlerde)?",
            trOptions = listOf("156", "186", "200", "206"),
            enQuestion = "How many bones are in an adult human body?",
            enOptions = listOf("156", "186", "200", "206")
        ),
        LocalizedQuestionData(
            id = 66,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "Android işletim sistemi hangi teknoloji devine aittir?",
            trOptions = listOf("Google", "Apple", "Microsoft", "Amazon"),
            enQuestion = "Which company owns and develops Android OS?",
            enOptions = listOf("Google", "Apple", "Microsoft", "Amazon")
        ),
        LocalizedQuestionData(
            id = 67,
            difficulty = Difficulty.EASY,
            category = Category.CINEMA_POP,
            correctAnswer = 2,
            trQuestion = "Star Wars serisinde Luke Skywalker'ın babası kimdir?",
            trOptions = listOf("Obi-Wan Kenobi", "Yoda", "Darth Vader", "Han Solo"),
            enQuestion = "Who is Luke Skywalker's father in Star Wars?",
            enOptions = listOf("Obi-Wan Kenobi", "Yoda", "Darth Vader", "Han Solo")
        ),
        LocalizedQuestionData(
            id = 68,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "Basketbolda serbest atış kaç sayı değerindedir?",
            trOptions = listOf("2", "1", "3", "0"),
            enQuestion = "How many points is a free throw worth in basketball?",
            enOptions = listOf("2", "1", "3", "0")
        ),
        LocalizedQuestionData(
            id = 69,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Kanada'nın başkenti neresidir?",
            trOptions = listOf("Ottawa", "Toronto", "Montreal", "Vancouver"),
            enQuestion = "What is the capital of Canada?",
            enOptions = listOf("Ottawa", "Toronto", "Montreal", "Vancouver")
        ),
        LocalizedQuestionData(
            id = 70,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 3,
            trQuestion = "Pusulanın renkli ucu daima hangi yönü gösterir?",
            trOptions = listOf("Güney", "Doğu", "Batı", "Kuzey"),
            enQuestion = "Which direction does the colored needle of a compass point to?",
            enOptions = listOf("South", "East", "West", "North")
        ),
        LocalizedQuestionData(
            id = 71,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Havadaki en yüksek oranda bulunan gaz hangisidir?",
            trOptions = listOf("Azot (Nitrojen)", "Oksijen", "Karbondioksit", "Argon"),
            enQuestion = "What is the most abundant gas in Earth's atmosphere?",
            enOptions = listOf("Nitrogen", "Oxygen", "Carbon Dioxide", "Argon")
        ),
        LocalizedQuestionData(
            id = 72,
            difficulty = Difficulty.EASY,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "Çanakkale Zaferi hangi yılda kazanılmıştır?",
            trOptions = listOf("1913", "1914", "1915", "1916"),
            enQuestion = "In which year was the Gallipoli Victory won?",
            enOptions = listOf("1913", "1914", "1915", "1916")
        ),
        LocalizedQuestionData(
            id = 73,
            difficulty = Difficulty.EASY,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Çığlık (The Scream) tablosu kime aittir?",
            trOptions = listOf("Pablo Picasso", "Edvard Munch", "Salvador Dali", "Gustav Klimt"),
            enQuestion = "Who painted The Scream?",
            enOptions = listOf("Pablo Picasso", "Edvard Munch", "Salvador Dali", "Gustav Klimt")
        ),
        LocalizedQuestionData(
            id = 74,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Avustralya'nın başkenti neresidir?",
            trOptions = listOf("Sidney", "Canberra", "Melbourne", "Brisbane"),
            enQuestion = "What is the capital of Australia?",
            enOptions = listOf("Sydney", "Canberra", "Melbourne", "Brisbane")
        ),
        LocalizedQuestionData(
            id = 75,
            difficulty = Difficulty.EASY,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "Bilgisayarda 'Ctrl + C' kısayolu hangi işlemi yapar?",
            trOptions = listOf("Kopyala", "Yapıştır", "Kes", "Geri Al"),
            enQuestion = "What does the keyboard shortcut 'Ctrl + C' do?",
            enOptions = listOf("Copy", "Paste", "Cut", "Undo")
        ),
        LocalizedQuestionData(
            id = 76,
            difficulty = Difficulty.EASY,
            category = Category.CINEMA_POP,
            correctAnswer = 3,
            trQuestion = "Hangisi Disney'in ünlü animasyon filmlerinden biridir?",
            trOptions = listOf("Shrek", "Buz Devri", "Kung Fu Panda", "Aslan Kral"),
            enQuestion = "Which of these is an iconic Disney animated film?",
            enOptions = listOf("Shrek", "Ice Age", "Kung Fu Panda", "The Lion King")
        ),
        LocalizedQuestionData(
            id = 77,
            difficulty = Difficulty.EASY,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Futbolda bir sarı kartın ardından aynı oyuncuya ikinci sarı kart gösterilirse ne olur?",
            trOptions = listOf("Kırmızı kart çıkar", "Oyuncu oyuna devam eder", "Penaltı verilir", "Taç atışı verilir"),
            enQuestion = "What happens in soccer when a player receives a second yellow card?",
            enOptions = listOf("Red card is shown", "Play continues", "Penalty awarded", "Throw-in given")
        ),
        LocalizedQuestionData(
            id = 78,
            difficulty = Difficulty.EASY,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Brezilya'nın resmi dili hangisidir?",
            trOptions = listOf("İspanyolca", "İngilizce", "Portekizce", "Fransızca"),
            enQuestion = "What is the official language of Brazil?",
            enOptions = listOf("Spanish", "English", "Portuguese", "French")
        ),
        LocalizedQuestionData(
            id = 79,
            difficulty = Difficulty.EASY,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Hangisi yenilenebilir bir enerji kaynağıdır?",
            trOptions = listOf("Kömür", "Güneş enerjisi", "Petrol", "Doğalgaz"),
            enQuestion = "Which of the following is a renewable energy source?",
            enOptions = listOf("Coal", "Solar energy", "Petroleum", "Natural gas")
        ),
        LocalizedQuestionData(
            id = 80,
            difficulty = Difficulty.EASY,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Bir yılda kaç hafta vardır (yaklaşık)?",
            trOptions = listOf("48", "52", "56", "60"),
            enQuestion = "How many weeks are in a standard year?",
            enOptions = listOf("48", "52", "56", "60")
        ),
        LocalizedQuestionData(
            id = 81,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Periyodik tabloda 'Au' simgesi hangi elementi temsil eder?",
            trOptions = listOf("Gümüş", "Altın", "Bakır", "Platin"),
            enQuestion = "Which element does 'Au' represent?",
            enOptions = listOf("Silver", "Gold", "Copper", "Platinum")
        ),
        LocalizedQuestionData(
            id = 82,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "I. Dünya Savaşı hangi yılda başlamıştır?",
            trOptions = listOf("1913", "1914", "1915", "1916"),
            enQuestion = "In which year did World War I begin?",
            enOptions = listOf("1913", "1914", "1915", "1916")
        ),
        LocalizedQuestionData(
            id = 83,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 3,
            trQuestion = "Dünyanın en büyük okyanusu hangisidir?",
            trOptions = listOf("Atlas Okyanusu", "Hint Okyanusu", "Arktik Okyanusu", "Büyük Okyanus (Pasifik)"),
            enQuestion = "What is the largest ocean on Earth?",
            enOptions = listOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean")
        ),
        LocalizedQuestionData(
            id = 84,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Suç ve Ceza adlı romanın yazarı kimdir?",
            trOptions = listOf("Dostoyevski", "Tolstoy", "Gogol", "Çehov"),
            enQuestion = "Who wrote Crime and Punishment?",
            enOptions = listOf("Dostoevsky", "Tolstoy", "Gogol", "Chekhov")
        ),
        LocalizedQuestionData(
            id = 85,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 2,
            trQuestion = "İlk programlanabilir bilgisayar kabul edilen ENIAC hangi on yılda yapılmıştır?",
            trOptions = listOf("1920'ler", "1930'lar", "1940'lar", "1950'ler"),
            enQuestion = "In which decade was ENIAC built?",
            enOptions = listOf("1920s", "1930s", "1940s", "1950s")
        ),
        LocalizedQuestionData(
            id = 86,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "DNA'nın çift sarmal yapısını 1953'te kimler keşfetmiştir?",
            trOptions = listOf("Darwin & Mendel", "Watson & Crick", "Pasteur & Koch", "Einstein & Bohr"),
            enQuestion = "Who discovered the double helix structure of DNA in 1953?",
            enOptions = listOf("Darwin & Mendel", "Watson & Crick", "Pasteur & Koch", "Einstein & Bohr")
        ),
        LocalizedQuestionData(
            id = 87,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Roma İmparatorluğu'nun ilk imparatoru kimdir?",
            trOptions = listOf("Augustus", "Julius Caesar", "Nero", "Tiberius"),
            enQuestion = "Who was the first Emperor of the Roman Empire?",
            enOptions = listOf("Augustus", "Julius Caesar", "Nero", "Tiberius")
        ),
        LocalizedQuestionData(
            id = 88,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Dünyanın en yüksek şelalesi olan Angel Şelalesi hangi ülkededir?",
            trOptions = listOf("Brezilya", "Kolombiya", "Venezuela", "Arjantin"),
            enQuestion = "In which country is Angel Falls located?",
            enOptions = listOf("Brazil", "Colombia", "Venezuela", "Argentina")
        ),
        LocalizedQuestionData(
            id = 89,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "2022 FIFA Dünya Kupası'nı hangi ülke kazanmıştır?",
            trOptions = listOf("Fransa", "Arjantin", "Brezilya", "Hırvatistan"),
            enQuestion = "Which country won the 2022 FIFA World Cup?",
            enOptions = listOf("France", "Argentina", "Brazil", "Croatia")
        ),
        LocalizedQuestionData(
            id = 90,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 3,
            trQuestion = "Baba (The Godfather) filminde Don Vito Corleone karakterini kim canlandırmıştır?",
            trOptions = listOf("Al Pacino", "Robert De Niro", "Joe Pesci", "Marlon Brando"),
            enQuestion = "Who played Don Vito Corleone in The Godfather (1972)?",
            enOptions = listOf("Al Pacino", "Robert De Niro", "Joe Pesci", "Marlon Brando")
        ),
        LocalizedQuestionData(
            id = 91,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 0,
            trQuestion = "Nobel Ödülleri hangi ülkenin başkentinde takdim edilir (Barış Ödülü hariç)?",
            trOptions = listOf("İsveç (Stockholm)", "Norveç (Oslo)", "Danimarka (Kopenhag)", "Finlandiya (Helsinki)"),
            enQuestion = "In which city are the Nobel Prizes awarded (except Peace)?",
            enOptions = listOf("Sweden (Stockholm)", "Norway (Oslo)", "Denmark (Copenhagen)", "Finland (Helsinki)")
        ),
        LocalizedQuestionData(
            id = 92,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Güneş Sistemi'ndeki en büyük gezegen hangisidir?",
            trOptions = listOf("Satürn", "Neptün", "Jüpiter", "Uranüs"),
            enQuestion = "What is the largest planet in the Solar System?",
            enOptions = listOf("Saturn", "Neptune", "Jupiter", "Uranus")
        ),
        LocalizedQuestionData(
            id = 93,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "Magna Carta sözleşmesi hangi yılda imzalanmıştır?",
            trOptions = listOf("1066", "1189", "1215", "1302"),
            enQuestion = "In which year was the Magna Carta signed?",
            enOptions = listOf("1066", "1189", "1215", "1302")
        ),
        LocalizedQuestionData(
            id = 94,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "İsviçre'nin resmi başkenti (federal merkezi) neresidir?",
            trOptions = listOf("Zürih", "Bern", "Cenevre", "Basel"),
            enQuestion = "What is the de facto federal city of Switzerland?",
            enOptions = listOf("Zurich", "Bern", "Geneva", "Basel")
        ),
        LocalizedQuestionData(
            id = 95,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Sefiller (Les Misérables) romanının yazarı kimdir?",
            trOptions = listOf("Victor Hugo", "Émile Zola", "Gustave Flaubert", "Alexandre Dumas"),
            enQuestion = "Who wrote Les Misérables?",
            enOptions = listOf("Victor Hugo", "Émile Zola", "Gustave Flaubert", "Alexandre Dumas")
        ),
        LocalizedQuestionData(
            id = 96,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Linux çekirdeğini 1991 yılında başlatan geliştirici kimdir?",
            trOptions = listOf("Richard Stallman", "Linus Torvalds", "Dennis Ritchie", "Ken Thompson"),
            enQuestion = "Who created the Linux kernel in 1991?",
            enOptions = listOf("Richard Stallman", "Linus Torvalds", "Dennis Ritchie", "Ken Thompson")
        ),
        LocalizedQuestionData(
            id = 97,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "Hangisi bir asal sayı DEĞİLDİR?",
            trOptions = listOf("17", "19", "23", "27"),
            enQuestion = "Which of the following numbers is NOT a prime number?",
            enOptions = listOf("17", "19", "23", "27")
        ),
        LocalizedQuestionData(
            id = 98,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Usain Bolt'a ait 100 metre erkekler dünya rekoru kaç saniyedir?",
            trOptions = listOf("9.58", "9.69", "9.72", "9.52"),
            enQuestion = "What is Usain Bolt's 100m world record in seconds?",
            enOptions = listOf("9.58", "9.69", "9.72", "9.52")
        ),
        LocalizedQuestionData(
            id = 99,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 1,
            trQuestion = "Matrix filminde 'Neo' karakterini canlandıran ünlü oyuncu kimdir?",
            trOptions = listOf("Brad Pitt", "Keanu Reeves", "Tom Cruise", "Johnny Depp"),
            enQuestion = "Who played Neo in The Matrix?",
            enOptions = listOf("Brad Pitt", "Keanu Reeves", "Tom Cruise", "Johnny Depp")
        ),
        LocalizedQuestionData(
            id = 100,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "II. Dünya Savaşı hangi yılda sona ermiştir?",
            trOptions = listOf("1943", "1944", "1945", "1946"),
            enQuestion = "In which year did World War II end?",
            enOptions = listOf("1943", "1944", "1945", "1946")
        ),
        LocalizedQuestionData(
            id = 101,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Afrika'nın en yüksek dağı olan Kilimanjaro hangi ülkededir?",
            trOptions = listOf("Tanzanya", "Kenya", "Uganda", "Etiyopya"),
            enQuestion = "In which country is Mount Kilimanjaro located?",
            enOptions = listOf("Tanzania", "Kenya", "Uganda", "Ethiopia")
        ),
        LocalizedQuestionData(
            id = 102,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Işığın kırılma indisi en yüksek olan ve doğada bilinen en sert mineral nedir?",
            trOptions = listOf("Kuvars", "Elmas", "Yakut", "Zümrüt"),
            enQuestion = "What is the hardest naturally occurring mineral on Earth?",
            enOptions = listOf("Quartz", "Diamond", "Ruby", "Emerald")
        ),
        LocalizedQuestionData(
            id = 103,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 2,
            trQuestion = "İlahi Komedya (Divina Commedia) adlı destansı eserin yazarı kimdir?",
            trOptions = listOf("Petrarca", "Boccaccio", "Dante Alighieri", "Machiavelli"),
            enQuestion = "Who wrote the Divine Comedy?",
            enOptions = listOf("Petrarch", "Boccaccio", "Dante Alighieri", "Machiavelli")
        ),
        LocalizedQuestionData(
            id = 104,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "Python programlama dilini geliştiren yazılımcı kimdir?",
            trOptions = listOf("Guido van Rossum", "Bjarne Stroustrup", "James Gosling", "Brendan Eich"),
            enQuestion = "Who created the Python programming language?",
            enOptions = listOf("Guido van Rossum", "Bjarne Stroustrup", "James Gosling", "Brendan Eich")
        ),
        LocalizedQuestionData(
            id = 105,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 3,
            trQuestion = "Olimpiyat halkalarında kaç farklı renk halka bulunur?",
            trOptions = listOf("3", "4", "6", "5"),
            enQuestion = "How many colored rings are on the Olympic flag?",
            enOptions = listOf("3", "4", "6", "5")
        ),
        LocalizedQuestionData(
            id = 106,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Fransız İhtilali hangi yılda gerçekleşmiştir?",
            trOptions = listOf("1776", "1789", "1799", "1804"),
            enQuestion = "In which year did the French Revolution begin?",
            enOptions = listOf("1776", "1789", "1799", "1804")
        ),
        LocalizedQuestionData(
            id = 107,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Dünyanın yüzölçümü bakımından en büyük gölü hangisidir?",
            trOptions = listOf("Baykal Gölü", "Superior Gölü", "Hazar Denizi", "Viktorya Gölü"),
            enQuestion = "What is the largest lake/inland body of water by surface area?",
            enOptions = listOf("Lake Baikal", "Lake Superior", "Caspian Sea", "Lake Victoria")
        ),
        LocalizedQuestionData(
            id = 108,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Kuduz aşısını bulan Fransız mikrobiyolog kimdir?",
            trOptions = listOf("Louis Pasteur", "Robert Koch", "Alexander Fleming", "Edward Jenner"),
            enQuestion = "Who developed the rabies vaccine?",
            enOptions = listOf("Louis Pasteur", "Robert Koch", "Alexander Fleming", "Edward Jenner")
        ),
        LocalizedQuestionData(
            id = 109,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Wimbledon Tenis Turnuvası hangi zemin üzerinde oynanır?",
            trOptions = listOf("Toprak", "Sert Kort", "Çim", "Halı"),
            enQuestion = "On what surface is the Wimbledon championship played?",
            enOptions = listOf("Clay", "Hard Court", "Grass", "Carpet")
        ),
        LocalizedQuestionData(
            id = 110,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 1,
            trQuestion = "Pulp Fiction ve Kill Bill filmlerinin yönetmeni kimdir?",
            trOptions = listOf("Martin Scorsese", "Quentin Tarantino", "David Fincher", "Ridley Scott"),
            enQuestion = "Who directed Pulp Fiction and Kill Bill?",
            enOptions = listOf("Martin Scorsese", "Quentin Tarantino", "David Fincher", "Ridley Scott")
        ),
        LocalizedQuestionData(
            id = 111,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Don Kişot romanının yazarı kimdir?",
            trOptions = listOf("Miguel de Cervantes", "Gabriel García Márquez", "Jorge Luis Borges", "Federico García Lorca"),
            enQuestion = "Who wrote Don Quixote?",
            enOptions = listOf("Miguel de Cervantes", "Gabriel García Márquez", "Jorge Luis Borges", "Federico García Lorca")
        ),
        LocalizedQuestionData(
            id = 112,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Ses dalgaları hangi ortamda YAYILAMAZ?",
            trOptions = listOf("Suda", "Boşlukta (Vakum)", "Havada", "Demirde"),
            enQuestion = "In which medium can sound waves NOT travel?",
            enOptions = listOf("Water", "Vacuum", "Air", "Iron")
        ),
        LocalizedQuestionData(
            id = 113,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 3,
            trQuestion = "Berlin Duvarı hangi yılda yıkılmıştır?",
            trOptions = listOf("1987", "1988", "1991", "1989"),
            enQuestion = "In which year did the Berlin Wall fall?",
            enOptions = listOf("1987", "1988", "1991", "1989")
        ),
        LocalizedQuestionData(
            id = 114,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Yeni Zelanda'nın başkenti neresidir?",
            trOptions = listOf("Wellington", "Auckland", "Christchurch", "Queenstown"),
            enQuestion = "What is the capital of New Zealand?",
            enOptions = listOf("Wellington", "Auckland", "Christchurch", "Queenstown")
        ),
        LocalizedQuestionData(
            id = 115,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 2,
            trQuestion = "C programlama dilini 1972'de geliştiren efsanevi bilgisayar bilimci kimdir?",
            trOptions = listOf("Alan Turing", "Bjarne Stroustrup", "Dennis Ritchie", "Ada Lovelace"),
            enQuestion = "Who created the C programming language?",
            enOptions = listOf("Alan Turing", "Bjarne Stroustrup", "Dennis Ritchie", "Ada Lovelace")
        ),
        LocalizedQuestionData(
            id = 116,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Santrançta en güçlü taş hangisidir?",
            trOptions = listOf("Kale", "Vezir", "Şah", "Fil"),
            enQuestion = "What is the most powerful piece in chess?",
            enOptions = listOf("Rook", "Queen", "King", "Bishop")
        ),
        LocalizedQuestionData(
            id = 117,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Penisilini 1928 yılında keşfeden bilim insanı kimdir?",
            trOptions = listOf("Alexander Fleming", "Louis Pasteur", "Marie Curie", "Gregor Mendel"),
            enQuestion = "Who discovered penicillin in 1928?",
            enOptions = listOf("Alexander Fleming", "Louis Pasteur", "Marie Curie", "Gregor Mendel")
        ),
        LocalizedQuestionData(
            id = 118,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 3,
            trQuestion = "NBA logosundaki siluet hangi efsane basketbolcuya aittir?",
            trOptions = listOf("Michael Jordan", "Kobe Bryant", "Magic Johnson", "Jerry West"),
            enQuestion = "Whose silhouette is featured in the official NBA logo?",
            enOptions = listOf("Michael Jordan", "Kobe Bryant", "Magic Johnson", "Jerry West")
        ),
        LocalizedQuestionData(
            id = 119,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "Inception, Interstellar ve Oppenheimer filmlerinin yönetmeni kimdir?",
            trOptions = listOf("Christopher Nolan", "Denis Villeneuve", "Stanley Kubrick", "David Lynch"),
            enQuestion = "Who directed Inception, Interstellar, and Oppenheimer?",
            enOptions = listOf("Christopher Nolan", "Denis Villeneuve", "Stanley Kubrick", "David Lynch")
        ),
        LocalizedQuestionData(
            id = 120,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Lozan Barış Antlaşması hangi yılda imzalanmıştır?",
            trOptions = listOf("1922", "1923", "1924", "1921"),
            enQuestion = "In which year was the Treaty of Lausanne signed?",
            enOptions = listOf("1922", "1923", "1924", "1921")
        ),
        LocalizedQuestionData(
            id = 121,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Avrupa'nın en uzun nehri hangisidir?",
            trOptions = listOf("Tuna", "Ren", "Volga", "Dinyester"),
            enQuestion = "What is the longest river in Europe?",
            enOptions = listOf("Danube", "Rhine", "Volga", "Dniester")
        ),
        LocalizedQuestionData(
            id = 122,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Bitkilerin yeşil rengini veren ve fotosentezi sağlayan pigment nedir?",
            trOptions = listOf("Karoten", "Klorofil", "Melanin", "Hemoglobin"),
            enQuestion = "What pigment gives plants their green color?",
            enOptions = listOf("Carotene", "Chlorophyll", "Melanin", "Hemoglobin")
        ),
        LocalizedQuestionData(
            id = 123,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Kürk Mantolu Madonna adlı eserin yazarı kimdir?",
            trOptions = listOf("Sabahattin Ali", "Ahmet Hamdi Tanpınar", "Oğuz Atay", "Peyami Safa"),
            enQuestion = "Who wrote Madonna in a Fur Coat?",
            enOptions = listOf("Sabahattin Ali", "Ahmet Hamdi Tanpinar", "Oguz Atay", "Peyami Safa")
        ),
        LocalizedQuestionData(
            id = 124,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "İlk yapay uydu Sputnik 1 hangi yıl uzaya fırlatılmıştır?",
            trOptions = listOf("1955", "1957", "1961", "1969"),
            enQuestion = "In which year was Sputnik 1 launched?",
            enOptions = listOf("1955", "1957", "1961", "1969")
        ),
        LocalizedQuestionData(
            id = 125,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 2,
            trQuestion = "Bir tam tur açı kaç derecedir?",
            trOptions = listOf("90", "180", "360", "270"),
            enQuestion = "How many degrees are in a full rotation?",
            enOptions = listOf("90", "180", "360", "270")
        ),
        LocalizedQuestionData(
            id = 126,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Amerika Birleşik Devletleri Bağımsızlık Bildirgesi hangi yılda kabul edilmiştir?",
            trOptions = listOf("1776", "1789", "1800", "1765"),
            enQuestion = "In which year was the US Declaration of Independence adopted?",
            enOptions = listOf("1776", "1789", "1800", "1765")
        ),
        LocalizedQuestionData(
            id = 127,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en derin tatlı su gölü hangisidir?",
            trOptions = listOf("Superior Gölü", "Baykal Gölü", "Victoria Gölü", "Tanganika Gölü"),
            enQuestion = "What is the deepest freshwater lake in the world?",
            enOptions = listOf("Lake Superior", "Lake Baikal", "Lake Victoria", "Lake Tanganyika")
        ),
        LocalizedQuestionData(
            id = 128,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "Periyodik tabloda atom numarası 1 olan element hangisidir?",
            trOptions = listOf("Helyum", "Lityum", "Karbon", "Hidrojen"),
            enQuestion = "Which element has an atomic number of 1 in the periodic table?",
            enOptions = listOf("Helium", "Lithium", "Carbon", "Hydrogen")
        ),
        LocalizedQuestionData(
            id = 129,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Futbol Dünya Kupası'nı 5 kez ile en çok kazanan ülke hangisidir?",
            trOptions = listOf("Brezilya", "Almanya", "İtalya", "Arjantin"),
            enQuestion = "Which country has won the FIFA World Cup the most times (5)?",
            enOptions = listOf("Brazil", "Germany", "Italy", "Argentina")
        ),
        LocalizedQuestionData(
            id = 130,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 2,
            trQuestion = "Yüzüklerin Efendisi film üçlemesinin yönetmeni kimdir?",
            trOptions = listOf("George Lucas", "Guillermo del Toro", "Peter Jackson", "Ridley Scott"),
            enQuestion = "Who directed The Lord of the Rings film trilogy?",
            enOptions = listOf("George Lucas", "Guillermo del Toro", "Peter Jackson", "Ridley Scott")
        ),
        LocalizedQuestionData(
            id = 131,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Tutunamayanlar romanının yazarı kimdir?",
            trOptions = listOf("Yusuf Atılgan", "Oğuz Atay", "Bilge Karasu", "Orhan Pamuk"),
            enQuestion = "Who is the author of Tutunamayanlar?",
            enOptions = listOf("Yusuf Atilgan", "Oguz Atay", "Bilge Karasu", "Orhan Pamuk")
        ),
        LocalizedQuestionData(
            id = 132,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Yerçekimi kanununu formüle eden İngiliz bilim insanı kimdir?",
            trOptions = listOf("Sir Isaac Newton", "Galileo Galilei", "Albert Einstein", "Johannes Kepler"),
            enQuestion = "Who formulated the law of universal gravitation?",
            enOptions = listOf("Sir Isaac Newton", "Galileo Galilei", "Albert Einstein", "Johannes Kepler")
        ),
        LocalizedQuestionData(
            id = 133,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "Bizans İmparatorluğu'nun başkenti Konstantinopolis hangi yıl Osmanlıların eline geçmiştir?",
            trOptions = listOf("1402", "1444", "1453", "1481"),
            enQuestion = "In what year did Constantinople fall to the Ottomans?",
            enOptions = listOf("1402", "1444", "1453", "1481")
        ),
        LocalizedQuestionData(
            id = 134,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Güney Amerika'nın en uzun sıradağları hangisidir?",
            trOptions = listOf("Alpler", "And Dağları", "Kayalık Dağlar", "Himalayalar"),
            enQuestion = "What is the longest mountain range in South America?",
            enOptions = listOf("Alps", "Andes", "Rockies", "Himalayas")
        ),
        LocalizedQuestionData(
            id = 135,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "Dünyadaki ilk bilgisayar programcısı kabul edilen kadın matematikçi kimdir?",
            trOptions = listOf("Ada Lovelace", "Grace Hopper", "Margaret Hamilton", "Katherine Johnson"),
            enQuestion = "Who is considered the world's first computer programmer?",
            enOptions = listOf("Ada Lovelace", "Grace Hopper", "Margaret Hamilton", "Katherine Johnson")
        ),
        LocalizedQuestionData(
            id = 136,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 3,
            trQuestion = "Bir piyanonun üzerinde toplam kaç standart tuş bulunur?",
            trOptions = listOf("64", "76", "84", "88"),
            enQuestion = "How many keys are on a standard acoustic piano?",
            enOptions = listOf("64", "76", "84", "88")
        ),
        LocalizedQuestionData(
            id = 137,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "İnsan vücudundaki en sert doku hangisidir?",
            trOptions = listOf("Kemik doku", "Diş minesi", "Kıkırdak", "Tırnak"),
            enQuestion = "What is the hardest substance/tissue in the human body?",
            enOptions = listOf("Bone tissue", "Tooth enamel", "Cartilage", "Nails")
        ),
        LocalizedQuestionData(
            id = 138,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Formula 1 tarihinde en çok şampiyonluk kazanan iki pilot (7 kez) Hamilton ve kimdir?",
            trOptions = listOf("Ayrton Senna", "Sebastian Vettel", "Michael Schumacher", "Alain Prost"),
            enQuestion = "Who shares the record for 7 F1 World Championships with Lewis Hamilton?",
            enOptions = listOf("Ayrton Senna", "Sebastian Vettel", "Michael Schumacher", "Alain Prost")
        ),
        LocalizedQuestionData(
            id = 139,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "Forrest Gump filminde başrolü canlandıran Oscar ödüllü oyuncu kimdir?",
            trOptions = listOf("Tom Hanks", "Robin Williams", "Dustin Hoffman", "Kevin Costner"),
            enQuestion = "Who starred as Forrest Gump in the 1994 film?",
            enOptions = listOf("Tom Hanks", "Robin Williams", "Dustin Hoffman", "Kevin Costner")
        ),
        LocalizedQuestionData(
            id = 140,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Mustafa Kemal Atatürk'e 'Gazi' unvanı ve Mareşal rütbesi hangi savaştan sonra verilmiştir?",
            trOptions = listOf("I. İnönü Savaşı", "Sakarya Meydan Muharebesi", "Büyük Taarruz", "Çanakkale Savaşı"),
            enQuestion = "After which battle was Ataturk granted the title Gazi and rank of Marshal?",
            enOptions = listOf("First Battle of Inonu", "Battle of Sakarya", "Great Offensive", "Gallipoli Campaign")
        ),
        LocalizedQuestionData(
            id = 141,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Büyük Kanyon (Grand Canyon) hangi ABD eyaletinde yer alır?",
            trOptions = listOf("Arizona", "Nevada", "Utah", "Kaliforniya"),
            enQuestion = "In which US state is the Grand Canyon located?",
            enOptions = listOf("Arizona", "Nevada", "Utah", "California")
        ),
        LocalizedQuestionData(
            id = 142,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Hangi element periyodik tabloda 'Ag' simgesiyle gösterilir?",
            trOptions = listOf("Altın", "Argon", "Gümüş", "Alüminyum"),
            enQuestion = "Which element is represented by 'Ag'?",
            enOptions = listOf("Gold", "Argon", "Silver", "Aluminum")
        ),
        LocalizedQuestionData(
            id = 143,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Saatleri Ayarlama Enstitüsü romanının yazarı kimdir?",
            trOptions = listOf("Ahmet Mithat", "Ahmet Hamdi Tanpınar", "Refik Halid Karay", "Kemal Tahir"),
            enQuestion = "Who wrote The Time Regulation Institute?",
            enOptions = listOf("Ahmet Mithat", "Ahmet Hamdi Tanpinar", "Refik Halid Karay", "Kemal Tahir")
        ),
        LocalizedQuestionData(
            id = 144,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 3,
            trQuestion = "Git sürüm kontrol sistemini 2005 yılında kim tasarlayıp yazmıştır?",
            trOptions = listOf("Steve Wozniak", "Bram Moolenaar", "Guido van Rossum", "Linus Torvalds"),
            enQuestion = "Who created the Git version control system in 2005?",
            enOptions = listOf("Steve Wozniak", "Bram Moolenaar", "Guido van Rossum", "Linus Torvalds")
        ),
        LocalizedQuestionData(
            id = 145,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Olimpiyat meşalesi nerede yakılarak ev sahibi şehre taşınır?",
            trOptions = listOf("Atina", "Olympia", "Sparta", "Girit"),
            enQuestion = "Where is the Olympic torch lit before its journey?",
            enOptions = listOf("Athens", "Olympia", "Sparta", "Crete")
        ),
        LocalizedQuestionData(
            id = 146,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Çin Seddi'nin inşasına hangi amaçla başlanmıştır?",
            trOptions = listOf("Kuzeyden gelen akınları durdurmak", "Ticaret yolu yapmak", "Tarım alanını korumak", "Dini tapınak oluşturmak"),
            enQuestion = "Why was the Great Wall of China initially constructed?",
            enOptions = listOf("To protect against northern invasions", "To create a trade route", "To enclose farmland", "To serve as a religious site")
        ),
        LocalizedQuestionData(
            id = 147,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Dünyanın en tuzlu göllerinden biri olan Lut Gölü (Ölü Deniz) hangi iki ülke arasındadır?",
            trOptions = listOf("Mısır - Libya", "Türkiye - Suriye", "İsrail - Ürdün", "Irak - İran"),
            enQuestion = "Between which two countries is the Dead Sea located?",
            enOptions = listOf("Egypt - Libya", "Turkey - Syria", "Israel - Jordan", "Iraq - Iran")
        ),
        LocalizedQuestionData(
            id = 148,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Radyoaktivite alanındaki çalışmalarıyla iki farklı bilim dalında Nobel kazanan kadın bilim insanı kimdir?",
            trOptions = listOf("Rosalind Franklin", "Marie Curie", "Lise Meitner", "Dorothy Hodgkin"),
            enQuestion = "Who won Nobel Prizes in two different scientific fields (Physics & Chemistry)?",
            enOptions = listOf("Rosalind Franklin", "Marie Curie", "Lise Meitner", "Dorothy Hodgkin")
        ),
        LocalizedQuestionData(
            id = 149,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Teniste 'Grand Slam' turnuvalarından Avustralya Açık hangi şehirde düzenlenir?",
            trOptions = listOf("Melbourne", "Sidney", "Brisbane", "Perth"),
            enQuestion = "In which city is the Australian Open held?",
            enOptions = listOf("Melbourne", "Sydney", "Brisbane", "Perth")
        ),
        LocalizedQuestionData(
            id = 150,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 3,
            trQuestion = "Matrix serisinde 'Kırmızı ve Mavi Hap' sahnesi kime aittir?",
            trOptions = listOf("Trinity", "Ajan Smith", "Cypher", "Morpheus"),
            enQuestion = "Who offers Neo the choice between the red pill and the blue pill?",
            enOptions = listOf("Trinity", "Agent Smith", "Cypher", "Morpheus")
        ),
        LocalizedQuestionData(
            id = 151,
            difficulty = Difficulty.MEDIUM,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Dönüşüm (Die Verwandlung) adlı ünlü öykünün yazarı kimdir?",
            trOptions = listOf("Franz Kafka", "Thomas Mann", "Hermann Hesse", "Friedrich Nietzsche"),
            enQuestion = "Who wrote The Metamorphosis?",
            enOptions = listOf("Franz Kafka", "Thomas Mann", "Hermann Hesse", "Friedrich Nietzsche")
        ),
        LocalizedQuestionData(
            id = 152,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Mutlak sıfır noktası kaç Kelvin derecedir?",
            trOptions = listOf("-273 K", "0 K", "100 K", "-100 K"),
            enQuestion = "What is absolute zero in Kelvin?",
            enOptions = listOf("-273 K", "0 K", "100 K", "-100 K")
        ),
        LocalizedQuestionData(
            id = 153,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "Mona Lisa tablosunu yapan Leonardo da Vinci hangi tarihi çağda yaşamıştır?",
            trOptions = listOf("İlk Çağ", "Orta Çağ", "Rönesans", "Aydınlanma Çağı"),
            enQuestion = "In which historical era did Leonardo da Vinci live?",
            enOptions = listOf("Ancient Era", "Middle Ages", "Renaissance", "Enlightenment")
        ),
        LocalizedQuestionData(
            id = 154,
            difficulty = Difficulty.MEDIUM,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Asya ve Avrupa kıtalarını birbirinden ayıran Rusya'daki ünlü sıradağlar hangisidir?",
            trOptions = listOf("Alpler", "Ural Dağları", "Kafkas Dağları", "Altay Dağları"),
            enQuestion = "Which mountain range forms a traditional boundary between Europe and Asia?",
            enOptions = listOf("Alps", "Ural Mountains", "Caucasus Mountains", "Altai Mountains")
        ),
        LocalizedQuestionData(
            id = 155,
            difficulty = Difficulty.MEDIUM,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "World Wide Web'in (WWW) mucidi İngiliz bilgisayar bilimcisi kimdir?",
            trOptions = listOf("Tim Berners-Lee", "Vint Cerf", "Bob Kahn", "Marc Andreessen"),
            enQuestion = "Who invented the World Wide Web in 1989?",
            enOptions = listOf("Tim Berners-Lee", "Vint Cerf", "Bob Kahn", "Marc Andreessen")
        ),
        LocalizedQuestionData(
            id = 156,
            difficulty = Difficulty.MEDIUM,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Nobel Barış Ödülü hangi şehirde verilir?",
            trOptions = listOf("Stockholm", "Oslo", "Cenevre", "Kopenhag"),
            enQuestion = "In which city is the Nobel Peace Prize awarded?",
            enOptions = listOf("Stockholm", "Oslo", "Geneva", "Copenhagen")
        ),
        LocalizedQuestionData(
            id = 157,
            difficulty = Difficulty.MEDIUM,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Gözün renkli kısmına ne ad verilir?",
            trOptions = listOf("Retina", "Kornea", "İris", "Göz bebeği"),
            enQuestion = "What is the colored part of the human eye called?",
            enOptions = listOf("Retina", "Cornea", "Iris", "Pupil")
        ),
        LocalizedQuestionData(
            id = 158,
            difficulty = Difficulty.MEDIUM,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "Tour de France bisiklet yarışında genel klasman liderinin giydiği forma ne renktir?",
            trOptions = listOf("Kırmızı", "Sarı", "Yeşil", "Beyaz"),
            enQuestion = "What color jersey does the overall leader of the Tour de France wear?",
            enOptions = listOf("Red", "Yellow", "Green", "White")
        ),
        LocalizedQuestionData(
            id = 159,
            difficulty = Difficulty.MEDIUM,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "Yıldız Savaşları (Star Wars) evrenini yaratan yönetmen kimdir?",
            trOptions = listOf("George Lucas", "Steven Spielberg", "J.J. Abrams", "James Cameron"),
            enQuestion = "Who created the Star Wars franchise?",
            enOptions = listOf("George Lucas", "Steven Spielberg", "J.J. Abrams", "James Cameron")
        ),
        LocalizedQuestionData(
            id = 160,
            difficulty = Difficulty.MEDIUM,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Titanic gemisi hangi yılda batmıştır?",
            trOptions = listOf("1910", "1912", "1914", "1916"),
            enQuestion = "In which year did the RMS Titanic sink?",
            enOptions = listOf("1910", "1912", "1914", "1916")
        ),
        LocalizedQuestionData(
            id = 161,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Genel Görelilik Teorisini 1915'te yayımlayan fizikçi kimdir?",
            trOptions = listOf("Max Planck", "Albert Einstein", "Niels Bohr", "Erwin Schrödinger"),
            enQuestion = "Who published the General Theory of Relativity in 1915?",
            enOptions = listOf("Max Planck", "Albert Einstein", "Niels Bohr", "Erwin Schrödinger")
        ),
        LocalizedQuestionData(
            id = 162,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "İlk insan Ay'a hangi yılda ayak basmıştır?",
            trOptions = listOf("1967", "1968", "1969", "1970"),
            enQuestion = "In which year did the Apollo 11 mission land on the Moon?",
            enOptions = listOf("1967", "1968", "1969", "1970")
        ),
        LocalizedQuestionData(
            id = 163,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Dünyanın en soğuk yeri olarak ölçülen Vostok İstasyonu hangi kıtadadır?",
            trOptions = listOf("Antarktika", "Kuzey Kutbu (Arktik)", "Grönland", "Kuzey Sibirya"),
            enQuestion = "On which continent is the ultra-cold Vostok Research Station located?",
            enOptions = listOf("Antarctica", "Arctic", "Greenland", "North Siberia")
        ),
        LocalizedQuestionData(
            id = 164,
            difficulty = Difficulty.HARD,
            category = Category.LITERATURE_ART,
            correctAnswer = 3,
            trQuestion = "Guernica tablosuyla İspanya İç Savaşı'nın vahşetini anlatan ünlü ressam kimdir?",
            trOptions = listOf("Salvador Dali", "Joan Miró", "Francisco Goya", "Pablo Picasso"),
            enQuestion = "Who painted the anti-war masterpiece Guernica?",
            enOptions = listOf("Salvador Dali", "Joan Miró", "Francisco Goya", "Pablo Picasso")
        ),
        LocalizedQuestionData(
            id = 165,
            difficulty = Difficulty.HARD,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Bitcoin'in 2008 yılındaki teknik manifestosunu yazan anonim kişi/grup kimdir?",
            trOptions = listOf("Nick Szabo", "Satoshi Nakamoto", "Hal Finney", "Vitalik Buterin"),
            enQuestion = "Who authored the 2008 Bitcoin whitepaper under a pseudonym?",
            enOptions = listOf("Nick Szabo", "Satoshi Nakamoto", "Hal Finney", "Vitalik Buterin")
        ),
        LocalizedQuestionData(
            id = 166,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Evrenin genişlediğini 1929'da gözlemleyerek kanıtlayan Amerikalı astronom kimdir?",
            trOptions = listOf("Carl Sagan", "Galileo Galilei", "Edwin Hubble", "Stephen Hawking"),
            enQuestion = "Which astronomer proved in 1929 that the Universe is expanding?",
            enOptions = listOf("Carl Sagan", "Galileo Galilei", "Edwin Hubble", "Stephen Hawking")
        ),
        LocalizedQuestionData(
            id = 167,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Peloponez Savaşı hangi iki antik Yunan şehir devleti arasında yaşanmıştır?",
            trOptions = listOf("Atina - Sparta", "Sparta - Tebai", "Atina - Korint", "Truva - Sparta"),
            enQuestion = "Between which two Greek city-states was the Peloponnesian War fought?",
            enOptions = listOf("Athens - Sparta", "Sparta - Thebes", "Athens - Corinth", "Troy - Sparta")
        ),
        LocalizedQuestionData(
            id = 168,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın deniz seviyesine göre en alçak kara noktası neresidir?",
            trOptions = listOf("Ölüm Vadisi", "Lut Gölü (Ölü Deniz) Kıyısı", "Hazar Çöküntüsü", "Danakil Çöküntüsü"),
            enQuestion = "What is the lowest land point on Earth's surface?",
            enOptions = listOf("Death Valley", "Dead Sea Shore", "Caspian Depression", "Danakil Depression")
        ),
        LocalizedQuestionData(
            id = 169,
            difficulty = Difficulty.HARD,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Futbolda Ballon d'Or ödülünü en çok kazanan futbolcu kimdir?",
            trOptions = listOf("Cristiano Ronaldo", "Pele", "Lionel Messi", "Johan Cruyff"),
            enQuestion = "Who has won the most Ballon d'Or awards in football history?",
            enOptions = listOf("Cristiano Ronaldo", "Pele", "Lionel Messi", "Johan Cruyff")
        ),
        LocalizedQuestionData(
            id = 170,
            difficulty = Difficulty.HARD,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "2001: A Space Odyssey filminin çığır açan yönetmeni kimdir?",
            trOptions = listOf("Stanley Kubrick", "Ridley Scott", "Francis Ford Coppola", "Ingmar Bergman"),
            enQuestion = "Who directed 2001: A Space Odyssey?",
            enOptions = listOf("Stanley Kubrick", "Ridley Scott", "Francis Ford Coppola", "Ingmar Bergman")
        ),
        LocalizedQuestionData(
            id = 171,
            difficulty = Difficulty.HARD,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Ulysses adlı modern edebiyat klasiğinin yazarı kimdir?",
            trOptions = listOf("Virginia Woolf", "James Joyce", "T.S. Eliot", "Samuel Beckett"),
            enQuestion = "Who wrote the landmark modernist novel Ulysses?",
            enOptions = listOf("Virginia Woolf", "James Joyce", "T.S. Eliot", "Samuel Beckett")
        ),
        LocalizedQuestionData(
            id = 172,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Kuantum mekaniğinde belirsizlik ilkesini ortaya koyan fizikçi kimdir?",
            trOptions = listOf("Werner Heisenberg", "Erwin Schrödinger", "Max Born", "Paul Dirac"),
            enQuestion = "Who formulated the Uncertainty Principle in quantum mechanics?",
            enOptions = listOf("Werner Heisenberg", "Erwin Schrödinger", "Max Born", "Paul Dirac")
        ),
        LocalizedQuestionData(
            id = 173,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 3,
            trQuestion = "Doğu Roma (Bizans) İmparatorluğu'nun son imparatoru kimdir?",
            trOptions = listOf("Justinianus", "I. Konstantin", "Basileios", "XI. Konstantinos Paleologos"),
            enQuestion = "Who was the last reigning Byzantine Emperor?",
            enOptions = listOf("Justinian I", "Constantine the Great", "Basil II", "Constantine XI Palaiologos")
        ),
        LocalizedQuestionData(
            id = 174,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Yüzölçümü bakımından Afrika'nın en büyük ülkesi hangisidir?",
            trOptions = listOf("Sudan", "Cezayir", "Kongo DC", "Nijerya"),
            enQuestion = "What is the largest country in Africa by land area?",
            enOptions = listOf("Sudan", "Algeria", "DR Congo", "Nigeria")
        ),
        LocalizedQuestionData(
            id = 175,
            difficulty = Difficulty.HARD,
            category = Category.TECHNOLOGY,
            correctAnswer = 2,
            trQuestion = "C++ programlama dilini 1979-1983 yıllarında Bell Labs'te geliştiren kimdir?",
            trOptions = listOf("Ken Thompson", "Dennis Ritchie", "Bjarne Stroustrup", "James Gosling"),
            enQuestion = "Who created the C++ programming language at Bell Labs?",
            enOptions = listOf("Ken Thompson", "Dennis Ritchie", "Bjarne Stroustrup", "James Gosling")
        ),
        LocalizedQuestionData(
            id = 176,
            difficulty = Difficulty.HARD,
            category = Category.GENERAL,
            correctAnswer = 0,
            trQuestion = "Periyodik tablodaki elementlerin sıralanışını belirleyen temel özellik nedir?",
            trOptions = listOf("Proton sayısı (Atom numarası)", "Kütle numarası", "Nötron sayısı", "Elektron ilgisi"),
            enQuestion = "What defines the order of elements in the modern periodic table?",
            enOptions = listOf("Proton number (Atomic number)", "Mass number", "Neutron number", "Electronegativity")
        ),
        LocalizedQuestionData(
            id = 177,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Işığın hem dalga hem parçacık ikiliğine sahip olduğunu öne süren 'Dalga-Parçacık İkiliği' teoremi kime aittir?",
            trOptions = listOf("Max Planck", "Louis de Broglie", "Enrico Fermi", "Richard Feynman"),
            enQuestion = "Who proposed the wave-particle duality theorem of matter in 1924?",
            enOptions = listOf("Max Planck", "Louis de Broglie", "Enrico Fermi", "Richard Feynman")
        ),
        LocalizedQuestionData(
            id = 178,
            difficulty = Difficulty.HARD,
            category = Category.SPORTS,
            correctAnswer = 3,
            trQuestion = "Modern Olimpiyat Oyunları'nın kurucusu kabul edilen Fransız eğitimci kimdir?",
            trOptions = listOf("Pierre de Coubertin", "Jules Rimet", "Henri Delaunay", "Avery Brundage"),
            enQuestion = "Who is recognized as the father of the modern Olympic Games?",
            enOptions = listOf("Pierre de Coubertin", "Jules Rimet", "Henri Delaunay", "Avery Brundage")
        ),
        LocalizedQuestionData(
            id = 179,
            difficulty = Difficulty.HARD,
            category = Category.CINEMA_POP,
            correctAnswer = 1,
            trQuestion = "Tarihte en çok Oscar kazanan üç filmden biri olan Ben-Hur kaç Akademi Ödülü kazanmıştır?",
            trOptions = listOf("10", "11", "12", "9"),
            enQuestion = "How many Academy Awards did Ben-Hur (1959) win?",
            enOptions = listOf("10", "11", "12", "9")
        ),
        LocalizedQuestionData(
            id = 180,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Osmanlı Devleti ile Haçlı orduları arasındaki Niğbolu Savaşı hangi yılda yapılmıştır?",
            trOptions = listOf("1396", "1402", "1389", "1444"),
            enQuestion = "In which year was the Battle of Nicopolis fought?",
            enOptions = listOf("1396", "1402", "1389", "1444")
        ),
        LocalizedQuestionData(
            id = 181,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Dünyada en çok ada sahibi olan ülke hangisidir?",
            trOptions = listOf("Norveç", "Endonezya", "İsveç", "Filipinler"),
            enQuestion = "Which country has the highest number of islands in the world?",
            enOptions = listOf("Norway", "Indonesia", "Sweden", "Philippines")
        ),
        LocalizedQuestionData(
            id = 182,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Evrendeki en yaygın element hangisidir?",
            trOptions = listOf("Hidrojen", "Helyum", "Oksijen", "Karbon"),
            enQuestion = "What is the most abundant chemical element in the universe?",
            enOptions = listOf("Hydrogen", "Helium", "Oxygen", "Carbon")
        ),
        LocalizedQuestionData(
            id = 183,
            difficulty = Difficulty.HARD,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Büyük Gözaltı ve '1984' distopik romanının yazarı kimdir?",
            trOptions = listOf("Aldous Huxley", "George Orwell", "Ray Bradbury", "Philip K. Dick"),
            enQuestion = "Who wrote the dystopian novel 1984?",
            enOptions = listOf("Aldous Huxley", "George Orwell", "Ray Bradbury", "Philip K. Dick")
        ),
        LocalizedQuestionData(
            id = 184,
            difficulty = Difficulty.HARD,
            category = Category.TECHNOLOGY,
            correctAnswer = 3,
            trQuestion = "Turing Testi kavramını 1950 yılında ortaya atan modern bilgisayar biliminin öncüsü kimdir?",
            trOptions = listOf("John von Neumann", "Claude Shannon", "Norbert Wiener", "Alan Turing"),
            enQuestion = "Who introduced the Turing Test for machine intelligence in 1950?",
            enOptions = listOf("John von Neumann", "Claude Shannon", "Norbert Wiener", "Alan Turing")
        ),
        LocalizedQuestionData(
            id = 185,
            difficulty = Difficulty.HARD,
            category = Category.GENERAL,
            correctAnswer = 1,
            trQuestion = "Antik Dünyanın Yedi Harikası'ndan günümüze kadar ayakta kalabilen tek yapı hangisidir?",
            trOptions = listOf("İskenderiye Feneri", "Keops Piramidi", "Babil'in Asma Bahçeleri", "Rodos Heykeli"),
            enQuestion = "Which of the Seven Wonders of the Ancient World is still standing?",
            enOptions = listOf("Lighthouse of Alexandria", "Great Pyramid of Giza", "Hanging Gardens of Babylon", "Colossus of Rhodes")
        ),
        LocalizedQuestionData(
            id = 186,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Otuz Yıl Savaşları'nı (1618-1648) sonlandıran ve modern devletler hukukunun temelini atan antlaşma hangisidir?",
            trOptions = listOf("Vestfalya Antlaşması", "Utrecht Antlaşması", "Viyana Kongresi", "Versay Antlaşması"),
            enQuestion = "Which 1648 peace treaties ended the Thirty Years' War in Europe?",
            enOptions = listOf("Peace of Westphalia", "Treaty of Utrecht", "Congress of Vienna", "Treaty of Versailles")
        ),
        LocalizedQuestionData(
            id = 187,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en kurak çölü kabul edilen Atacama Çölü hangi ülkededir?",
            trOptions = listOf("Peru", "Şili", "Arjantin", "Bolivya"),
            enQuestion = "In which country is the hyper-arid Atacama Desert predominantly located?",
            enOptions = listOf("Peru", "Chile", "Argentina", "Bolivia")
        ),
        LocalizedQuestionData(
            id = 188,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Hücrede enerji (ATP) üretiminden sorumlu organel hangisidir?",
            trOptions = listOf("Ribozom", "Endoplazmik Retikulum", "Mitokondri", "Golgi Aygıtı"),
            enQuestion = "Which organelle is responsible for generating cellular ATP energy?",
            enOptions = listOf("Ribosome", "Endoplasmic Reticulum", "Mitochondria", "Golgi Apparatus")
        ),
        LocalizedQuestionData(
            id = 189,
            difficulty = Difficulty.HARD,
            category = Category.SPORTS,
            correctAnswer = 1,
            trQuestion = "Teniste kariyer 'Grand Slam'i yapan ve 24 tekler şampiyonluğuyla rekor kıran erkek raket kimdir?",
            trOptions = listOf("Roger Federer", "Novak Djokovic", "Rafael Nadal", "Pete Sampras"),
            enQuestion = "Which male tennis player holds the record for 24 Grand Slam singles titles?",
            enOptions = listOf("Roger Federer", "Novak Djokovic", "Rafael Nadal", "Pete Sampras")
        ),
        LocalizedQuestionData(
            id = 190,
            difficulty = Difficulty.HARD,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "Schindler'in Listesi ve Jurassic Park filmlerinin efsanevi yönetmeni kimdir?",
            trOptions = listOf("Steven Spielberg", "Martin Scorsese", "George Lucas", "Brian De Palma"),
            enQuestion = "Who directed Schindler's List and Jurassic Park?",
            enOptions = listOf("Steven Spielberg", "Martin Scorsese", "George Lucas", "Brian De Palma")
        ),
        LocalizedQuestionData(
            id = 191,
            difficulty = Difficulty.HARD,
            category = Category.LITERATURE_ART,
            correctAnswer = 2,
            trQuestion = "Kaybolan Zamanın İzinde (À la recherche du temps perdu) 7 ciltlik nehir romanının yazarı kimdir?",
            trOptions = listOf("Jean-Paul Sartre", "Albert Camus", "Marcel Proust", "Gustave Flaubert"),
            enQuestion = "Who authored In Search of Lost Time?",
            enOptions = listOf("Jean-Paul Sartre", "Albert Camus", "Marcel Proust", "Gustave Flaubert")
        ),
        LocalizedQuestionData(
            id = 192,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Gözlemlenebilir evrendeki en hızlı hız olan ışık hızı c boşlukta yaklaşık kaç m/s'dir?",
            trOptions = listOf("299.792.458 m/s", "150.000.000 m/s", "340.000.000 m/s", "3.000.000 m/s"),
            enQuestion = "What is the exact speed of light in vacuum in m/s?",
            enOptions = listOf("299,792,458 m/s", "150,000,000 m/s", "340,000,000 m/s", "3,000,000 m/s")
        ),
        LocalizedQuestionData(
            id = 193,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Yüzyıl Savaşları hangi iki Avrupa krallığı arasında gerçekleşmiştir?",
            trOptions = listOf("İspanya - Portekiz", "İngiltere - Fransa", "Kutsal Roma - Fransa", "İngiltere - İskoçya"),
            enQuestion = "Between which two kingdoms was the Hundred Years' War fought?",
            enOptions = listOf("Spain - Portugal", "England - France", "Holy Roman Empire - France", "England - Scotland")
        ),
        LocalizedQuestionData(
            id = 194,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 3,
            trQuestion = "Dünyanın en yüksek kesintisiz platolarından biri olan 'Dünyanın Çatısı' lakaplı plato hangisidir?",
            trOptions = listOf("Anadolu Platosu", "Dekkan Platosu", "Kolorado Platosu", "Tibet Platosu"),
            enQuestion = "Which high plateau is famously called the 'Roof of the World'?",
            enOptions = listOf("Anatolian Plateau", "Deccan Plateau", "Colorado Plateau", "Tibetan Plateau")
        ),
        LocalizedQuestionData(
            id = 195,
            difficulty = Difficulty.HARD,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Ethereum blokzinciri platformunun kurucusu olan Rus-Kanadalı yazılımcı kimdir?",
            trOptions = listOf("Gavin Wood", "Vitalik Buterin", "Charles Hoskinson", "Satoshi Nakamoto"),
            enQuestion = "Who is the primary co-founder of the Ethereum blockchain platform?",
            enOptions = listOf("Gavin Wood", "Vitalik Buterin", "Charles Hoskinson", "Satoshi Nakamoto")
        ),
        LocalizedQuestionData(
            id = 196,
            difficulty = Difficulty.HARD,
            category = Category.GENERAL,
            correctAnswer = 0,
            trQuestion = "Uluslararası Para Fonu'nun (IMF) genel merkezi hangi şehirdedir?",
            trOptions = listOf("Washington, D.C.", "New York", "Cenevre", "Londra"),
            enQuestion = "Where is the headquarters of the International Monetary Fund (IMF)?",
            enOptions = listOf("Washington, D.C.", "New York", "Geneva", "London")
        ),
        LocalizedQuestionData(
            id = 197,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Periyodik tablodaki en ağır doğal element hangisidir?",
            trOptions = listOf("Kurşun", "Plutonyum", "Uranyum", "Radyum"),
            enQuestion = "What is the heaviest naturally occurring element in the periodic table?",
            enOptions = listOf("Lead", "Plutonium", "Uranium", "Radium")
        ),
        LocalizedQuestionData(
            id = 198,
            difficulty = Difficulty.HARD,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Formula 1 Monaco Grand Prix'sini 6 kez kazanarak 'Monaco Kralı' lakabını alan efsane pilot kimdir?",
            trOptions = listOf("Ayrton Senna", "Graham Hill", "Michael Schumacher", "Alain Prost"),
            enQuestion = "Which driver won the Monaco Grand Prix 6 times?",
            enOptions = listOf("Ayrton Senna", "Graham Hill", "Michael Schumacher", "Alain Prost")
        ),
        LocalizedQuestionData(
            id = 199,
            difficulty = Difficulty.HARD,
            category = Category.CINEMA_POP,
            correctAnswer = 1,
            trQuestion = "Yurttaş Kane (Citizen Kane, 1941) filminin yönetmeni ve başrol oyuncusu kimdir?",
            trOptions = listOf("Alfred Hitchcock", "Orson Welles", "Billy Wilder", "John Huston"),
            enQuestion = "Who directed and starred in the cinematic classic Citizen Kane (1941)?",
            enOptions = listOf("Alfred Hitchcock", "Orson Welles", "Billy Wilder", "John Huston")
        ),
        LocalizedQuestionData(
            id = 200,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "İlk yazılı kanunlar olarak bilinen Urgakina Kanunları hangi Mezopotamya uygarlığına aittir?",
            trOptions = listOf("Babiller", "Asurlar", "Sümerler", "Akadlar"),
            enQuestion = "Which Mesopotamian civilization produced the Code of Urukagina?",
            enOptions = listOf("Babylonians", "Assyrians", "Sumerians", "Akkadians")
        ),
        LocalizedQuestionData(
            id = 201,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en dar boğazlarından biri olan ve Karadeniz ile Marmara'yı bağlayan boğaz hangisidir?",
            trOptions = listOf("Çanakkale Boğazı", "İstanbul Boğazı", "Cebelitarık Boğazı", "Hürmüz Boğazı"),
            enQuestion = "Which strait connects the Black Sea to the Sea of Marmara?",
            enOptions = listOf("Dardanelles", "Bosphorus", "Strait of Gibraltar", "Strait of Hormuz")
        ),
        LocalizedQuestionData(
            id = 202,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Kara deliklerin Hawking Radyasyonu yaydığını 1974'te teorileştiren teorik fizikçi kimdir?",
            trOptions = listOf("Stephen Hawking", "Roger Penrose", "Kip Thorne", "Subrahmanyan Chandrasekhar"),
            enQuestion = "Who theorized that black holes emit radiation in 1974?",
            enOptions = listOf("Stephen Hawking", "Roger Penrose", "Kip Thorne", "Subrahmanyan Chandrasekhar")
        ),
        LocalizedQuestionData(
            id = 203,
            difficulty = Difficulty.HARD,
            category = Category.LITERATURE_ART,
            correctAnswer = 3,
            trQuestion = "Bülbülü Öldürmek (To Kill a Mockingbird) romanının yazarı kimdir?",
            trOptions = listOf("Toni Morrison", "John Steinbeck", "F. Scott Fitzgerald", "Harper Lee"),
            enQuestion = "Who wrote the Pulitzer Prize-winning novel To Kill a Mockingbird?",
            enOptions = listOf("Toni Morrison", "John Steinbeck", "F. Scott Fitzgerald", "Harper Lee")
        ),
        LocalizedQuestionData(
            id = 204,
            difficulty = Difficulty.HARD,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "İnternetin atası kabul edilen ve ilk paket anahtarlamalı ağ olan sistem hangisidir?",
            trOptions = listOf("NSFNET", "ARPANET", "ALOHANET", "CYCLADES"),
            enQuestion = "Which network was the technical precursor to the modern Internet?",
            enOptions = listOf("NSFNET", "ARPANET", "ALOHANET", "CYCLADES")
        ),
        LocalizedQuestionData(
            id = 205,
            difficulty = Difficulty.HARD,
            category = Category.GENERAL,
            correctAnswer = 2,
            trQuestion = "Dünya Mirası Listesi'ni yöneten Birleşmiş Milletler organı hangisidir?",
            trOptions = listOf("UNICEF", "WHO", "UNESCO", "UNHCR"),
            enQuestion = "Which UN specialized agency administers the World Heritage List?",
            enOptions = listOf("UNICEF", "WHO", "UNESCO", "UNHCR")
        ),
        LocalizedQuestionData(
            id = 206,
            difficulty = Difficulty.HARD,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "MÖ 1274'te Hititler ile Mısırlılar arasında yapılan ve tarihteki ilk yazılı barış antlaşmasıyla sonuçlanan savaş hangisidir?",
            trOptions = listOf("Kadeş Savaşı", "Meciddo Savaşı", "Peloponez Savaşı", "Maraton Savaşı"),
            enQuestion = "Which battle led to the earliest known recorded peace treaty in history?",
            enOptions = listOf("Battle of Kadesh", "Battle of Megiddo", "Battle of Peloponnesus", "Battle of Marathon")
        ),
        LocalizedQuestionData(
            id = 207,
            difficulty = Difficulty.HARD,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Dünyanın en yüksek kesintisiz şelalesi olan Angel Şelalesi'nin yaklaşık yüksekliği kaç metredir?",
            trOptions = listOf("520 m", "740 m", "979 m", "1250 m"),
            enQuestion = "What is the approximate total height of Angel Falls in meters?",
            enOptions = listOf("520 m", "740 m", "979 m", "1250 m")
        ),
        LocalizedQuestionData(
            id = 208,
            difficulty = Difficulty.HARD,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Kuantum elektrodinamiği (QED) ve kuantum hesaplama öncüsü olan Nobel ödüllü Amerikalı fizikçi kimdir?",
            trOptions = listOf("J. Robert Oppenheimer", "Richard Feynman", "Murray Gell-Mann", "John Bardeen"),
            enQuestion = "Which theoretical physicist pioneered Quantum Electrodynamics and Feynman diagrams?",
            enOptions = listOf("J. Robert Oppenheimer", "Richard Feynman", "Murray Gell-Mann", "John Bardeen")
        ),
        LocalizedQuestionData(
            id = 209,
            difficulty = Difficulty.HARD,
            category = Category.SPORTS,
            correctAnswer = 0,
            trQuestion = "Olimpiyatlarda 23'ü altın toplam 28 madalya ile tüm zamanların en çok madalya kazanan sporcusu kimdir?",
            trOptions = listOf("Michael Phelps", "Usain Bolt", "Larisa Latynina", "Carl Lewis"),
            enQuestion = "Who is the most decorated Olympian of all time with 28 medals?",
            enOptions = listOf("Michael Phelps", "Usain Bolt", "Larisa Latynina", "Carl Lewis")
        ),
        LocalizedQuestionData(
            id = 210,
            difficulty = Difficulty.HARD,
            category = Category.CINEMA_POP,
            correctAnswer = 2,
            trQuestion = "Kuzuların Sessizliği (1991) filminde Dr. Hannibal Lecter rolüyle Oscar kazanan aktör kimdir?",
            trOptions = listOf("Jack Nicholson", "Daniel Day-Lewis", "Anthony Hopkins", "Gary Oldman"),
            enQuestion = "Who won an Academy Award for portraying Dr. Hannibal Lecter in 1991?",
            enOptions = listOf("Jack Nicholson", "Daniel Day-Lewis", "Anthony Hopkins", "Gary Oldman")
        ),
        LocalizedQuestionData(
            id = 211,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Higgs bozonunun varlığı CERN LHC deneyinde hangi yılda deneysel olarak doğrulanmıştır?",
            trOptions = listOf("2008", "2012", "2015", "2019"),
            enQuestion = "In which year was the discovery of the Higgs boson confirmed at CERN?",
            enOptions = listOf("2008", "2012", "2015", "2019")
        ),
        LocalizedQuestionData(
            id = 212,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Osmanlı Devleti'nin imzaladığı son antlaşma olan Sevr Antlaşması hangi tarihte imzalanmıştır?",
            trOptions = listOf("10 Ağustos 1920", "24 Temmuz 1923", "30 Ekim 1918", "16 Mart 1921"),
            enQuestion = "On what date was the Treaty of Sèvres signed?",
            enOptions = listOf("August 10, 1920", "July 24, 1923", "October 30, 1918", "March 16, 1921")
        ),
        LocalizedQuestionData(
            id = 213,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Dünyanın en derin noktası olan Mariana Çukuru'ndaki Challenger Çukuru yaklaşık kaç metre derinliktedir?",
            trOptions = listOf("8.848 m", "10.050 m", "10.994 m", "12.262 m"),
            enQuestion = "What is the approximate depth of the Challenger Deep in the Mariana Trench?",
            enOptions = listOf("8,848 m", "10,050 m", "10,994 m", "12,262 m")
        ),
        LocalizedQuestionData(
            id = 214,
            difficulty = Difficulty.EXPERT,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Rönesans başyapıtı Sistine Şapeli tavan fresklerini yapan İtalyan usta kimdir?",
            trOptions = listOf("Raffaello", "Michelangelo", "Donatello", "Botticelli"),
            enQuestion = "Who painted the Sistine Chapel ceiling frescoes?",
            enOptions = listOf("Raphael", "Michelangelo", "Donatello", "Botticelli")
        ),
        LocalizedQuestionData(
            id = 215,
            difficulty = Difficulty.EXPERT,
            category = Category.TECHNOLOGY,
            correctAnswer = 0,
            trQuestion = "Unix işletim sisteminin geliştirilmesinde kullanılan ve C dilinin öncüsü olan dil hangisidir?",
            trOptions = listOf("B Dili", "Fortran", "Pascal", "Assembly"),
            enQuestion = "Which language developed by Ken Thompson directly preceded C?",
            enOptions = listOf("B Language", "Fortran", "Pascal", "Assembly")
        ),
        LocalizedQuestionData(
            id = 216,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "DNA'daki 4 nükleotid bazdan timinin yerine RNA'da hangi baz geçer?",
            trOptions = listOf("Adenin", "Guanin", "Sitozin", "Urasil"),
            enQuestion = "Which nitrogenous base replaces thymine in RNA molecules?",
            enOptions = listOf("Adenine", "Guanine", "Cytosine", "Uracil")
        ),
        LocalizedQuestionData(
            id = 217,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Doğu Roma (Bizans) İmparatorluğu'nda Nika İsyanı hangi imparatorun döneminde çıkmıştır?",
            trOptions = listOf("I. Justinianus", "I. Konstantin", "Herakleios", "Theodosius"),
            enQuestion = "During whose reign did the famous Nika Riots occur in Constantinople?",
            enOptions = listOf("Justinian I", "Constantine I", "Heraclius", "Theodosius I")
        ),
        LocalizedQuestionData(
            id = 218,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Tristan da Cunha adası dünyanın en izole yerleşim yeri olarak hangi okyanusta bulunur?",
            trOptions = listOf("Güney Atlas Okyanusu", "Güney Pasifik", "Hint Okyanusu", "Kuzey Buz Denizi"),
            enQuestion = "In which ocean is the remote volcanic archipelago of Tristan da Cunha located?",
            enOptions = listOf("South Atlantic Ocean", "South Pacific", "Indian Ocean", "Arctic Ocean")
        ),
        LocalizedQuestionData(
            id = 219,
            difficulty = Difficulty.EXPERT,
            category = Category.LITERATURE_ART,
            correctAnswer = 2,
            trQuestion = "Fermat'nın Son Teoremi'ni 1994 yılında 350 yıl sonra kanıtlayan İngiliz matematikçi kimdir?",
            trOptions = listOf("Terence Tao", "Kurt Gödel", "Andrew Wiles", "Grigori Perelman"),
            enQuestion = "Which mathematician successfully proved Fermat's Last Theorem in 1994?",
            enOptions = listOf("Terence Tao", "Kurt Gödel", "Andrew Wiles", "Grigori Perelman")
        ),
        LocalizedQuestionData(
            id = 220,
            difficulty = Difficulty.EXPERT,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Asimetrik şifrelemenin temelini oluşturan RSA algoritmasının 'R' harfi kime aittir?",
            trOptions = listOf("Ronald Graham", "Ron Rivest", "Richard Stallman", "Robert Metcalfe"),
            enQuestion = "In the RSA public-key cryptosystem, who does the 'R' stand for?",
            enOptions = listOf("Ronald Graham", "Ron Rivest", "Richard Stallman", "Robert Metcalfe")
        ),
        LocalizedQuestionData(
            id = 221,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Nobel Fizik Ödülü'nü iki kez kazanan tek fizikçi kimdir?",
            trOptions = listOf("John Bardeen", "Marie Curie", "Linus Pauling", "Frederick Sanger"),
            enQuestion = "Who is the only person to win the Nobel Prize in Physics twice?",
            enOptions = listOf("John Bardeen", "Marie Curie", "Linus Pauling", "Frederick Sanger")
        ),
        LocalizedQuestionData(
            id = 222,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 2,
            trQuestion = "Antik Mısır'da tek tanrılı Aten dinini kuran ve Tutankamon'un babası kabul edilen firavun kimdir?",
            trOptions = listOf("II. Ramses", "Hatşepsut", "Akhenaton (IV. Amenhotep)", "I. Seti"),
            enQuestion = "Which Pharaoh instituted an early form of monotheism centered on Aten?",
            enOptions = listOf("Ramesses II", "Hatshepsut", "Akhenaten (Amenhotep IV)", "Seti I")
        ),
        LocalizedQuestionData(
            id = 223,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en yüksek kesintisiz volkanı olan Ojos del Salado hangi iki ülke sınırındadır?",
            trOptions = listOf("Peru - Ekvador", "Şili - Arjantin", "Bolivya - Şili", "Kolombiya - Venezuela"),
            enQuestion = "Between which two countries is Ojos del Salado, the world's highest volcano, situated?",
            enOptions = listOf("Peru - Ecuador", "Chile - Argentina", "Bolivia - Chile", "Colombia - Venezuela")
        ),
        LocalizedQuestionData(
            id = 224,
            difficulty = Difficulty.EXPERT,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Beethoven'ın 'Koro' başlıklı 9. Senfonisi'nin son bölümünde hangi şairin 'Neşeye Övgü' şiiri kullanılmıştır?",
            trOptions = listOf("Friedrich Schiller", "J.W. von Goethe", "Heinrich Heine", "Rainer Maria Rilke"),
            enQuestion = "Whose poem 'Ode to Joy' is used in Beethoven's 9th Symphony?",
            enOptions = listOf("Friedrich Schiller", "J.W. von Goethe", "Heinrich Heine", "Rainer Maria Rilke")
        ),
        LocalizedQuestionData(
            id = 225,
            difficulty = Difficulty.EXPERT,
            category = Category.TECHNOLOGY,
            correctAnswer = 3,
            trQuestion = "İlk mikroişlemci olan 4-bitlik Intel 4004 hangi yılda piyasaya sürülmüştür?",
            trOptions = listOf("1968", "1969", "1970", "1971"),
            enQuestion = "In which year was the first commercial single-chip microprocessor, Intel 4004, released?",
            enOptions = listOf("1968", "1969", "1970", "1971")
        ),
        LocalizedQuestionData(
            id = 226,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Gözlemlenebilir evrenin yaklaşık yaşı kaç milyar yıldır?",
            trOptions = listOf("4.5 milyar yıl", "9.2 milyar yıl", "13.8 milyar yıl", "20.1 milyar yıl"),
            enQuestion = "What is the estimated age of the observable universe?",
            enOptions = listOf("4.5 billion years", "9.2 billion years", "13.8 billion years", "20.1 billion years")
        ),
        LocalizedQuestionData(
            id = 227,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "1071 Malazgirt Meydan Muharebesi'nde Büyük Selçuklu Hükümdarı Sultan Alparslan hangi Bizans İmparatoru'nu mağlup etmiştir?",
            trOptions = listOf("Romen Diyojen", "IX. Konstantin", "VII. Mihail", "I. Aleksios"),
            enQuestion = "Which Byzantine Emperor was defeated and captured by Sultan Alp Arslan at Manzikert?",
            enOptions = listOf("Romanos IV Diogenes", "Constantine IX", "Michael VII", "Alexios I")
        ),
        LocalizedQuestionData(
            id = 228,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en yüksek başkenti kabul edilen La Paz (idari) hangi ülkededir?",
            trOptions = listOf("Ekvador", "Bolivya", "Peru", "Nepal"),
            enQuestion = "In which country is La Paz, the world's highest national administrative capital?",
            enOptions = listOf("Ecuador", "Bolivia", "Peru", "Nepal")
        ),
        LocalizedQuestionData(
            id = 229,
            difficulty = Difficulty.EXPERT,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Olimpiyatlarda maraton yarışının mesafesinin tam olarak 42.195 metre olarak sabitlendiği yıl hangi Olimpiyattır?",
            trOptions = listOf("1896 Atina", "1900 Paris", "1908 Londra", "1924 Paris"),
            enQuestion = "At which Olympic Games was the exact 42.195 km marathon distance established?",
            enOptions = listOf("1896 Athens", "1900 Paris", "1908 London", "1924 Paris")
        ),
        LocalizedQuestionData(
            id = 230,
            difficulty = Difficulty.EXPERT,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "Sinema tarihinde 'Auteur' teorisinin en büyük temsilcilerinden olan ve Vertigo, Psycho filmlerini çeken yönetmen kimdir?",
            trOptions = listOf("Alfred Hitchcock", "Stanley Kubrick", "Orson Welles", "Federico Fellini"),
            enQuestion = "Who is universally recognized as the 'Master of Suspense' in cinema?",
            enOptions = listOf("Alfred Hitchcock", "Stanley Kubrick", "Orson Welles", "Federico Fellini")
        ),
        LocalizedQuestionData(
            id = 231,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 1,
            trQuestion = "Kütleçekim dalgalarını (Gravitational Waves) 2015 yılında ilk kez doğrudan tespit eden gözlemevi hangisidir?",
            trOptions = listOf("CERN", "LIGO", "James Webb", "Hubble"),
            enQuestion = "Which scientific facility made the historic first direct detection of gravitational waves in 2015?",
            enOptions = listOf("CERN", "LIGO", "James Webb", "Hubble")
        ),
        LocalizedQuestionData(
            id = 232,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 3,
            trQuestion = "Hititlerin başkenti olan Hattuşaş antik kenti günümüzde Türkiye'nin hangi ilindedir?",
            trOptions = listOf("Konya", "Ankara", "Yozgat", "Çorum"),
            enQuestion = "In which modern Turkish province is Hattusa, the ancient Hittite capital, located?",
            enOptions = listOf("Konya", "Ankara", "Yozgat", "Corum")
        ),
        LocalizedQuestionData(
            id = 233,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 0,
            trQuestion = "Dünyanın en büyük kanyonu kabul edilen Yarlung Tsangpo Büyük Kanyonu hangi ülkededir?",
            trOptions = listOf("Çin (Tibet)", "ABD", "Meksika", "Avustralya"),
            enQuestion = "In which territory is the Yarlung Tsangpo Grand Canyon located?",
            enOptions = listOf("China (Tibet)", "USA", "Mexico", "Australia")
        ),
        LocalizedQuestionData(
            id = 234,
            difficulty = Difficulty.EXPERT,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Poincaré Sanısı'nı 2002-2003 yıllarında çözerek Fields Madalyası ve 1 Milyon Dolar Millenium ödülünü reddeden dahi Rus kimdir?",
            trOptions = listOf("Andrei Kolmogorov", "Grigori Perelman", "Stanislav Smirnov", "Vladimir Arnold"),
            enQuestion = "Which Russian mathematician solved the Poincaré Conjecture and declined the Fields Medal?",
            enOptions = listOf("Andrei Kolmogorov", "Grigori Perelman", "Stanislav Smirnov", "Vladimir Arnold")
        ),
        LocalizedQuestionData(
            id = 235,
            difficulty = Difficulty.EXPERT,
            category = Category.TECHNOLOGY,
            correctAnswer = 2,
            trQuestion = "İnternet protokolü TCP/IP'nin mimarları kabul edilen ve 'İnternetin Babaları' sayılan ikili kimdir?",
            trOptions = listOf("Gates & Jobs", "Page & Brin", "Vint Cerf & Bob Kahn", "Ritchie & Thompson"),
            enQuestion = "Who are recognized as the primary co-designers of the TCP/IP protocols?",
            enOptions = listOf("Gates & Jobs", "Page & Brin", "Vint Cerf & Bob Kahn", "Ritchie & Thompson")
        ),
        LocalizedQuestionData(
            id = 236,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 0,
            trQuestion = "Standart Model'de güçlü nükleer kuvveti taşıyan ayar bozonu hangisidir?",
            trOptions = listOf("Gluon", "Foton", "W ve Z Bozonları", "Graviton"),
            enQuestion = "Which fundamental gauge boson mediates the strong nuclear force in quantum physics?",
            enOptions = listOf("Gluon", "Photon", "W and Z Bosons", "Graviton")
        ),
        LocalizedQuestionData(
            id = 237,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 1,
            trQuestion = "Roma İmparatorluğu'nda Hristiyanlığı serbest bırakan 313 tarihli ferman hangisidir?",
            trOptions = listOf("İznik Bildirgesi", "Milano Fermanı", "Nantes Fermanı", "Tours Bildirisi"),
            enQuestion = "Which 313 AD proclamation permanently established religious tolerance for Christianity in Rome?",
            enOptions = listOf("Edict of Nicaea", "Edict of Milan", "Edict of Nantes", "Edict of Tours")
        ),
        LocalizedQuestionData(
            id = 238,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 2,
            trQuestion = "Yerkabuğunun ortalama kalınlığı okyanus tabanlarında yaklaşık kaç kilometredir?",
            trOptions = listOf("1-2 km", "5-10 km", "30-50 km", "70-100 km"),
            enQuestion = "What is the average thickness of oceanic crust?",
            enOptions = listOf("1-2 km", "5-10 km", "30-50 km", "70-100 km")
        ),
        LocalizedQuestionData(
            id = 239,
            difficulty = Difficulty.EXPERT,
            category = Category.LITERATURE_ART,
            correctAnswer = 0,
            trQuestion = "Klasik müzikte 'Ay Işığı Sonatı' (Moonlight Sonata) hangi ünlü besteciye aittir?",
            trOptions = listOf("Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Johann Sebastian Bach", "Frédéric Chopin"),
            enQuestion = "Who composed the Piano Sonata No. 14, known as the 'Moonlight Sonata'?",
            enOptions = listOf("Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Johann Sebastian Bach", "Frédéric Chopin")
        ),
        LocalizedQuestionData(
            id = 240,
            difficulty = Difficulty.EXPERT,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "İlk yapay zeka programlarından olan ve 1997'de Dünya Satranç Şampiyonu Garry Kasparov'u yenen IBM bilgisayarı hangisidir?",
            trOptions = listOf("Watson", "Deep Blue", "ENIAC", "DeepMind"),
            enQuestion = "Which IBM supercomputer defeated World Chess Champion Garry Kasparov in 1997?",
            enOptions = listOf("Watson", "Deep Blue", "ENIAC", "DeepMind")
        ),
        LocalizedQuestionData(
            id = 241,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 3,
            trQuestion = "DNA replikasyonunda yeni DNA zincirini sentezleyen ana enzim hangisidir?",
            trOptions = listOf("Helikaz", "Ligaz", "Primaz", "DNA Polimeraz"),
            enQuestion = "Which primary enzyme synthesizes DNA molecules from deoxyribonucleotides during replication?",
            enOptions = listOf("Helicase", "Ligase", "Primase", "DNA Polymerase")
        ),
        LocalizedQuestionData(
            id = 242,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "Büyük Selçuklu İmparatorluğu'nun ünlü veziri Nizamülmülk'ün kaleme aldığı siyasetname türündeki başyapıt nedir?",
            trOptions = listOf("Siyasetnâme", "Kutadgu Bilig", "Divanü Lügati't-Türk", "Atabetü'l-Hakayık"),
            enQuestion = "What is the celebrated treatise on government and kingship written by Nizam al-Mulk?",
            enOptions = listOf("Siyasatnama", "Kutadgu Bilig", "Divan-i Lughat al-Turk", "Atabetul Hakayik")
        ),
        LocalizedQuestionData(
            id = 243,
            difficulty = Difficulty.EXPERT,
            category = Category.GEOGRAPHY,
            correctAnswer = 1,
            trQuestion = "Dünyanın en derin kanyonlarından biri olan Bakır Kanyonu (Barranca del Cobre) hangi ülkededir?",
            trOptions = listOf("ABD", "Meksika", "Brezilya", "Şili"),
            enQuestion = "In which country is the Copper Canyon (Barranca del Cobre) network located?",
            enOptions = listOf("USA", "Mexico", "Brazil", "Chile")
        ),
        LocalizedQuestionData(
            id = 244,
            difficulty = Difficulty.EXPERT,
            category = Category.SPORTS,
            correctAnswer = 2,
            trQuestion = "Dünya Kupası tarihinde tek bir maçta 5 gol atan tek futbolcu (1994, Rusya - Kamerun) kimdir?",
            trOptions = listOf("Ronaldo Nazário", "Gerd Müller", "Oleg Salenko", "Just Fontaine"),
            enQuestion = "Who scored a record 5 goals in a single World Cup match in 1994?",
            enOptions = listOf("Ronaldo Nazario", "Gerd Muller", "Oleg Salenko", "Just Fontaine")
        ),
        LocalizedQuestionData(
            id = 245,
            difficulty = Difficulty.EXPERT,
            category = Category.CINEMA_POP,
            correctAnswer = 0,
            trQuestion = "Tarihte en çok Oscar adaylığı elde eden besteci (50+ adaylık) kimdir?",
            trOptions = listOf("John Williams", "Hans Zimmer", "Ennio Morricone", "Max Steiner"),
            enQuestion = "Which film composer has earned over 50 Academy Award nominations?",
            enOptions = listOf("John Williams", "Hans Zimmer", "Ennio Morricone", "Max Steiner")
        ),
        LocalizedQuestionData(
            id = 246,
            difficulty = Difficulty.EXPERT,
            category = Category.LITERATURE_ART,
            correctAnswer = 1,
            trQuestion = "Rönesans başyapıtı 'Atina Okulu' (The School of Athens) freskini yapan İtalyan ressam kimdir?",
            trOptions = listOf("Michelangelo", "Raffaello Sanzio", "Leonardo da Vinci", "Tiziano"),
            enQuestion = "Who painted The School of Athens fresco in the Vatican?",
            enOptions = listOf("Michelangelo", "Raphael (Raffaello Sanzio)", "Leonardo da Vinci", "Titian")
        ),
        LocalizedQuestionData(
            id = 247,
            difficulty = Difficulty.EXPERT,
            category = Category.SCIENCE,
            correctAnswer = 2,
            trQuestion = "Güneş yüzeyinin yaklaşık sıcaklığı kaç derecedir (Kelvin/Celsius)?",
            trOptions = listOf("1.500 °C", "3.000 °C", "5.500 °C", "15.000 °C"),
            enQuestion = "What is the approximate effective surface temperature of the Sun (Photosphere)?",
            enOptions = listOf("1,500 °C", "3,000 °C", "5,500 °C", "15,000 °C")
        ),
        LocalizedQuestionData(
            id = 248,
            difficulty = Difficulty.EXPERT,
            category = Category.HISTORY,
            correctAnswer = 0,
            trQuestion = "1683 II. Viyana Kuşatması'nda Osmanlı ordusunun başkomutanı (Sadrazam) kimdir?",
            trOptions = listOf("Merzifonlu Kara Mustafa Paşa", "Köprülü Fazıl Ahmed Paşa", "Sokollu Mehmed Paşa", "Kuyucu Murad Paşa"),
            enQuestion = "Who was the Grand Vizier and commander of the Ottoman army during the 1683 Siege of Vienna?",
            enOptions = listOf("Merzifonlu Kara Mustafa Pasha", "Koprulu Fazil Ahmed Pasha", "Sokollu Mehmed Pasha", "Kuyucu Murad Pasha")
        ),
        LocalizedQuestionData(
            id = 249,
            difficulty = Difficulty.EXPERT,
            category = Category.TECHNOLOGY,
            correctAnswer = 1,
            trQuestion = "Bilgisayar biliminde 'P versus NP' problemi hangi ünlü 7 Milenyum Ödülü Probleminden biridir ve ödülü ne kadardır?",
            trOptions = listOf("500.000 $", "1.000.000 $", "2.000.000 $", "5.000.000 $"),
            enQuestion = "What is the Millennium Prize bounty offered by the Clay Mathematics Institute for P vs NP?",
            enOptions = listOf("$500,000", "$1,000,000", "$2,000,000", "$5,000,000")
        ),
        LocalizedQuestionData(
            id = 250,
            difficulty = Difficulty.EXPERT,
            category = Category.GENERAL,
            correctAnswer = 2,
            trQuestion = "Tarihte Nobel Ödülü kazanan ilk kadın bilim insanı kimdir (1903 Fizik)?",
            trOptions = listOf("Rosalind Franklin", "Ada Lovelace", "Marie Curie", "Irène Joliot-Curie"),
            enQuestion = "Who was the first woman ever to be awarded a Nobel Prize (1903)?",
            enOptions = listOf("Rosalind Franklin", "Ada Lovelace", "Marie Curie", "Irène Joliot-Curie")
        ),
    )

    fun getGameQuestions(language: Language = Language.TURKISH): List<Question> {
        // Randomly pick ladder: 5 EASY, 5 MEDIUM, 3 HARD, 2 EXPERT from 250 pool
        val easyPool = rawQuestions.filter { it.difficulty == Difficulty.EASY }.shuffled().take(5)
        val mediumPool = rawQuestions.filter { it.difficulty == Difficulty.MEDIUM }.shuffled().take(5)
        val hardPool = rawQuestions.filter { it.difficulty == Difficulty.HARD }.shuffled().take(3)
        val expertPool = rawQuestions.filter { it.difficulty == Difficulty.EXPERT }.shuffled().take(2)
        val session = easyPool + mediumPool + hardPool + expertPool

        return session.mapIndexed { index, data ->
            val prize = if (index < prizeSteps.size) prizeSteps[index] else 1_000_000
            val isTurkish = language == Language.TURKISH
            val qText = if (isTurkish) data.trQuestion else data.enQuestion
            val opts = if (isTurkish) data.trOptions else data.enOptions
            Question(
                id = data.id,
                question = qText,
                options = opts,
                correctAnswer = data.correctAnswer,
                difficulty = data.difficulty,
                category = data.category,
                prizeMoney = prize
            )
        }
    }

    fun getQuestionsByIds(ids: List<Int>, language: Language): List<Question> {
        val isTurkish = language == Language.TURKISH
        return ids.mapIndexed { index, id ->
            val data = rawQuestions.find { it.id == id } ?: rawQuestions[index % rawQuestions.size]
            val prize = if (index < prizeSteps.size) prizeSteps[index] else 1_000_000
            val qText = if (isTurkish) data.trQuestion else data.enQuestion
            val opts = if (isTurkish) data.trOptions else data.enOptions
            Question(
                id = data.id,
                question = qText,
                options = opts,
                correctAnswer = data.correctAnswer,
                difficulty = data.difficulty,
                category = data.category,
                prizeMoney = prize
            )
        }
    }

    fun getTotalQuestions(): Int = rawQuestions.size
}
