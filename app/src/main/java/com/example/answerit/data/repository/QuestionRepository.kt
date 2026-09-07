package com.example.answerit.data.repository

import com.example.answerit.data.model.Difficulty
import com.example.answerit.data.model.Language
import com.example.answerit.data.model.Question

object QuestionRepository {

    data class LocalizedQuestionData(
        val id: Int,
        val difficulty: Difficulty,
        val prizeMoney: Int,
        val correctAnswer: Int,
        val translations: Map<Language, Pair<String, List<String>>>
    )

    private val prizeSteps = listOf(
        100, 200, 300, 500, 1_000,
        2_000, 4_000, 8_000, 16_000, 32_000,
        64_000, 125_000, 250_000, 500_000, 1_000_000
    )

    private val rawQuestions: List<LocalizedQuestionData> = listOf(
        // EASY QUESTIONS (Level 1 - 5)
        LocalizedQuestionData(
            id = 1,
            difficulty = Difficulty.EASY,
            prizeMoney = 100,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Türkiye'nin başkenti neresidir?" to listOf("İstanbul", "Ankara", "İzmir", "Bursa")),
                Language.ENGLISH to ("What is the capital of Turkey?" to listOf("Istanbul", "Ankara", "Izmir", "Bursa")),
                Language.CHINESE to ("土耳其的首都是哪里？" to listOf("伊斯坦布尔", "安卡拉", "伊兹密尔", "布尔萨")),
                Language.SPANISH to ("¿Cuál es la capital de Turquía?" to listOf("Estambul", "Ankara", "Esmirna", "Bursa")),
                Language.ARABIC to ("ما هي عاصمة تركيا؟" to listOf("إسطنبول", "أنقرة", "إزمير", "بورصة")),
                Language.GERMAN to ("Was ist die Hauptstadt der Türkei?" to listOf("Istanbul", "Ankara", "Izmir", "Bursa")),
                Language.FRENCH to ("Quelle est la capitale de la Turquie?" to listOf("Istanbul", "Ankara", "Izmir", "Bursa")),
                Language.RUSSIAN to ("Какова столица Турции?" to listOf("Стамбул", "Анкара", "Измир", "Бурса")),
                Language.HINDI to ("तुर्की की राजधानी क्या है?" to listOf("इस्तांबुल", "अंकारा", "इज़मीर", "बुर्सा")),
                Language.JAPANESE to ("トルコの首都はどこですか？" to listOf("イスタンブール", "アンカラ", "イズミル", "ブルサ")),
                Language.KOREAN to ("터키의 수도는 어디입니까?" to listOf("이스탄불", "앙카라", "이즈미르", "부르사")),
                Language.PORTUGUESE to ("Qual é a capital da Turquia?" to listOf("Istambul", "Ancara", "Esmirna", "Bursa")),
                Language.VIETNAMESE to ("Thủ đô của Thổ Nhĩ Kỳ là gì?" to listOf("Istanbul", "Ankara", "Izmir", "Bursa")),
                Language.ITALIAN to ("Qual è la capitale della Turchia?" to listOf("Istanbul", "Ankara", "Izmir", "Bursa"))
            )
        ),
        LocalizedQuestionData(
            id = 2,
            difficulty = Difficulty.EASY,
            prizeMoney = 200,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Hangi gezegen Güneş'e en yakındır?" to listOf("Venüs", "Merkür", "Mars", "Dünya")),
                Language.ENGLISH to ("Which planet is closest to the Sun?" to listOf("Venus", "Mercury", "Mars", "Earth")),
                Language.CHINESE to ("哪个行星离太阳最近？" to listOf("金星", "水星", "火星", "地球")),
                Language.SPANISH to ("¿Qué planeta está más cerca del Sol?" to listOf("Venus", "Mercurio", "Marte", "Tierra")),
                Language.ARABIC to ("أي كوكب أقرب إلى الشمس؟" to listOf("الزهرة", "عطارد", "المريخ", "الأرض")),
                Language.GERMAN to ("Welcher Planet ist der Sonne am nächsten?" to listOf("Venus", "Merkur", "Mars", "Erde")),
                Language.FRENCH to ("Quelle planète est la plus proche du Soleil?" to listOf("Vénus", "Mercure", "Mars", "Terre")),
                Language.RUSSIAN to ("Какая планета ближе всего к Солнцу?" to listOf("Венера", "Меркурий", "Марс", "Земля")),
                Language.HINDI to ("सूर्य के सबसे निकट कौन सा ग्रह है?" to listOf("शुक्र", "बुध", "मंगल", "पृथ्वी")),
                Language.JAPANESE to ("太陽に最も近い惑星はどれですか？" to listOf("金星", "水星", "火星", "地球")),
                Language.KOREAN to ("태양에 가장 가까운 행성은 무엇입니까?" to listOf("금성", "수성", "화성", "지구")),
                Language.PORTUGUESE to ("Qual planeta está mais próximo do Sol?" to listOf("Vênus", "Mercúrio", "Marte", "Terra")),
                Language.VIETNAMESE to ("Hành tinh nào gần Mặt Trời nhất?" to listOf("Sao Kim", "Sao Thủy", "Sao Hỏa", "Trái Đất")),
                Language.ITALIAN to ("Quale pianeta è il più vicino al Sole?" to listOf("Venere", "Mercurio", "Marte", "Terra"))
            )
        ),
        LocalizedQuestionData(
            id = 3,
            difficulty = Difficulty.EASY,
            prizeMoney = 300,
            correctAnswer = 2,
            translations = mapOf(
                Language.TURKISH to ("İstanbul hangi yılda fethedilmiştir?" to listOf("1451", "1452", "1453", "1454")),
                Language.ENGLISH to ("In which year was Istanbul conquered?" to listOf("1451", "1452", "1453", "1454")),
                Language.CHINESE to ("伊斯坦布尔在哪一年被征服？" to listOf("1451", "1452", "1453", "1454")),
                Language.SPANISH to ("¿En qué año fue conquistada Estambul?" to listOf("1451", "1452", "1453", "1454")),
                Language.ARABIC to ("في أي عام تم فتح إسطنبول؟" to listOf("1451", "1452", "1453", "1454")),
                Language.GERMAN to ("In welchem Jahr wurde Istanbul erobert?" to listOf("1451", "1452", "1453", "1454")),
                Language.FRENCH to ("En quelle année Istanbul a-t-elle été conquise?" to listOf("1451", "1452", "1453", "1454")),
                Language.RUSSIAN to ("В каком году был завоеван Стамбул?" to listOf("1451", "1452", "1453", "1454")),
                Language.HINDI to ("इस्तांबुल किस वर्ष में जीता गया था?" to listOf("1451", "1452", "1453", "1454")),
                Language.JAPANESE to ("イスタンブールは何年に征服されましたか？" to listOf("1451", "1452", "1453", "1454")),
                Language.KOREAN to ("이스탄불은 몇 년에 정복되었습니까?" to listOf("1451", "1452", "1453", "1454")),
                Language.PORTUGUESE to ("Em que ano Istambul foi conquistada?" to listOf("1451", "1452", "1453", "1454")),
                Language.VIETNAMESE to ("Istanbul được chinh phục vào năm nào?" to listOf("1451", "1452", "1453", "1454")),
                Language.ITALIAN to ("In quale anno è stata conquistata Istanbul?" to listOf("1451", "1452", "1453", "1454"))
            )
        ),
        LocalizedQuestionData(
            id = 4,
            difficulty = Difficulty.EASY,
            prizeMoney = 500,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Hangi element periyodik tabloda 'Fe' sembolü ile gösterilir?" to listOf("Flor", "Demir", "Fosfor", "Fermiyum")),
                Language.ENGLISH to ("Which element is represented by 'Fe' in the periodic table?" to listOf("Fluorine", "Iron", "Phosphorus", "Fermium")),
                Language.CHINESE to ("哪个元素在元素周期表中用'Fe'表示？" to listOf("氟", "铁", "磷", "镄")),
                Language.SPANISH to ("¿Qué elemento está representado por 'Fe' en la tabla periódica?" to listOf("Flúor", "Hierro", "Fósforo", "Fermio")),
                Language.ARABIC to ("أي عنصر يمثله الرمز 'Fe' في الجدول الدوري؟" to listOf("الفلور", "الحديد", "الفوسفور", "الفرميوم")),
                Language.GERMAN to ("Welches Element wird durch 'Fe' im Periodensystem dargestellt?" to listOf("Fluor", "Eisen", "Phosphor", "Fermium")),
                Language.FRENCH to ("Quel élément est représenté par 'Fe' dans le tableau périodique?" to listOf("Fluor", "Fer", "Phosphore", "Fermium")),
                Language.RUSSIAN to ("Какой элемент обозначается как 'Fe'?" to listOf("Фтор", "Железо", "Фосфор", "Фермий")),
                Language.HINDI to ("आवर्त सारणी में 'Fe' किस तत्व का प्रतीक है?" to listOf("फ्लोरीन", "लोहा", "फास्फोरस", "फर्मियम")),
                Language.JAPANESE to ("周期表で'Fe'で表される元素はどれですか？" to listOf("フッ素", "鉄", "リン", "フェルミウム")),
                Language.KOREAN to ("주기율표에서 'Fe'로 표시되는 원소는?" to listOf("플루오린", "철", "인", "페르뮴")),
                Language.PORTUGUESE to ("Qual elemento é representado por 'Fe' na tabela periódica?" to listOf("Flúor", "Ferro", "Fósforo", "Férmio")),
                Language.VIETNAMESE to ("Nguyên tố nào có ký hiệu 'Fe' trong bảng tuần hoàn?" to listOf("Flo", "Sắt", "Phốt pho", "Fermi")),
                Language.ITALIAN to ("Quale elemento è rappresentato da 'Fe' nella tavola periodica?" to listOf("Fluoro", "Ferro", "Fosforo", "Fermio"))
            )
        ),
        LocalizedQuestionData(
            id = 5,
            difficulty = Difficulty.EASY,
            prizeMoney = 1000,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Türkiye'nin en yüksek dağı hangisidir?" to listOf("Erciyes", "Ağrı Dağı", "Uludağ", "Kaçkar")),
                Language.ENGLISH to ("What is Turkey's highest mountain?" to listOf("Erciyes", "Mount Ararat", "Uludag", "Kackar")),
                Language.CHINESE to ("土耳其最高的山是什么？" to listOf("埃尔吉耶斯", "阿勒山", "乌鲁达", "卡奇卡尔")),
                Language.SPANISH to ("¿Cuál es la montaña más alta de Turquía?" to listOf("Erciyes", "Monte Ararat", "Uludag", "Kackar")),
                Language.ARABIC to ("ما هي أعلى قمة جبلية في تركيا؟" to listOf("إرجييس", "أرارات", "أولوداغ", "كاكار")),
                Language.GERMAN to ("Was ist der höchste Berg der Türkei?" to listOf("Erciyes", "Ararat", "Uludag", "Kackar")),
                Language.FRENCH to ("Quelle est la plus haute montagne de Turquie?" to listOf("Erciyes", "Mont Ararat", "Uludag", "Kackar")),
                Language.RUSSIAN to ("Какая гора самая высокая в Турции?" to listOf("Эрджияс", "Арарат", "Улудаг", "Качкар")),
                Language.HINDI to ("तुर्की का सबसे ऊंचा पहाड़ कौन सा है?" to listOf("एर्सीयेस", "अरारत", "उलूदाग", "काकर")),
                Language.JAPANESE to ("トルコで最も高い山は何ですか？" to listOf("エルジエス", "アララト", "ウルダー", "カチカル")),
                Language.KOREAN to ("터키에서 가장 높은 산은?" to listOf("에르지예스", "아라라트", "울루다그", "카치카르")),
                Language.PORTUGUESE to ("Qual é a montanha mais alta da Turquia?" to listOf("Erciyes", "Monte Ararat", "Uludag", "Kackar")),
                Language.VIETNAMESE to ("Ngọn núi cao nhất Thổ Nhĩ Kỳ là gì?" to listOf("Erciyes", "Núi Ararat", "Uludag", "Kackar")),
                Language.ITALIAN to ("Qual è la montagna più alta della Turchia?" to listOf("Erciyes", "Monte Ararat", "Uludag", "Kackar"))
            )
        ),

        // MEDIUM QUESTIONS (Level 6 - 10)
        LocalizedQuestionData(
            id = 6,
            difficulty = Difficulty.MEDIUM,
            prizeMoney = 2000,
            correctAnswer = 3,
            translations = mapOf(
                Language.TURKISH to ("Türkiye Cumhuriyeti hangi yılda kurulmuştur?" to listOf("1920", "1921", "1922", "1923")),
                Language.ENGLISH to ("In which year was the Republic of Turkey founded?" to listOf("1920", "1921", "1922", "1923")),
                Language.CHINESE to ("土耳其共和国成立于哪一年？" to listOf("1920", "1921", "1922", "1923")),
                Language.SPANISH to ("¿En qué año se fundó la República de Turquía?" to listOf("1920", "1921", "1922", "1923")),
                Language.ARABIC to ("في أي عام تأسست جمهورية تركيا؟" to listOf("1920", "1921", "1922", "1923")),
                Language.GERMAN to ("In welchem Jahr wurde die Republik Türkei gegründet?" to listOf("1920", "1921", "1922", "1923")),
                Language.FRENCH to ("En quelle année la République de Turquie a-t-elle été fondée?" to listOf("1920", "1921", "1922", "1923")),
                Language.RUSSIAN to ("В каком году была основана Турецкая Республика?" to listOf("1920", "1921", "1922", "1923")),
                Language.HINDI to ("तुर्की गणराज्य किस वर्ष स्थापित हुआ?" to listOf("1920", "1921", "1922", "1923")),
                Language.JAPANESE to ("トルコ共和国は何年に設立されましたか？" to listOf("1920", "1921", "1922", "1923")),
                Language.KOREAN to ("터키 공화국은 몇 년에 수립되었습니까?" to listOf("1920", "1921", "1922", "1923")),
                Language.PORTUGUESE to ("Em que ano foi fundada a República da Turquia?" to listOf("1920", "1921", "1922", "1923")),
                Language.VIETNAMESE to ("Cộng hòa Thổ Nhĩ Kỳ thành lập năm nào?" to listOf("1920", "1921", "1922", "1923")),
                Language.ITALIAN to ("In quale anno è stata fondata la Repubblica di Turchia?" to listOf("1920", "1921", "1922", "1923"))
            )
        ),
        LocalizedQuestionData(
            id = 7,
            difficulty = Difficulty.MEDIUM,
            prizeMoney = 4000,
            correctAnswer = 3,
            translations = mapOf(
                Language.TURKISH to ("İnsan vücudundaki en büyük organ hangisidir?" to listOf("Kalp", "Beyin", "Karaciğer", "Deri")),
                Language.ENGLISH to ("What is the largest organ in the human body?" to listOf("Heart", "Brain", "Liver", "Skin")),
                Language.CHINESE to ("人体最大的器官是什么？" to listOf("心脏", "大脑", "肝脏", "皮肤")),
                Language.SPANISH to ("¿Cuál es el órgano más grande del cuerpo humano?" to listOf("Corazón", "Cerebro", "Hígado", "Piel")),
                Language.ARABIC to ("ما هو أكبر عضو في جسم الإنسان؟" to listOf("القلب", "الدماغ", "الكبد", "الجلد")),
                Language.GERMAN to ("Was ist das größte Organ im menschlichen Körper?" to listOf("Herz", "Gehirn", "Leber", "Haut")),
                Language.FRENCH to ("Quel est le plus grand organe du corps humain?" to listOf("Cœur", "Cerveau", "Foie", "Peau")),
                Language.RUSSIAN to ("Какой самый большой орган в организме человека?" to listOf("Сердце", "Мозг", "Печень", "Кожа")),
                Language.HINDI to ("मानव शरीर का सबसे बड़ा अंग कौन सा है?" to listOf("दिल", "दिमाग", "जिगर", "त्वचा")),
                Language.JAPANESE to ("人体の最も大きな臓器は何ですか？" to listOf("心臓", "脳", "肝臓", "皮膚")),
                Language.KOREAN to ("인체에서 가장 큰 기관은 무엇입니까?" to listOf("심장", "뇌", "간", "피부")),
                Language.PORTUGUESE to ("Qual é o maior órgão do corpo humano?" to listOf("Coração", "Cérebro", "Fígado", "Pele")),
                Language.VIETNAMESE to ("Cơ quan lớn nhất trong cơ thể người là gì?" to listOf("Tim", "Não", "Gan", "Da")),
                Language.ITALIAN to ("Qual è l'organo più grande del corpo umano?" to listOf("Cuore", "Cervello", "Fegato", "Pelle"))
            )
        ),
        LocalizedQuestionData(
            id = 8,
            difficulty = Difficulty.MEDIUM,
            prizeMoney = 8000,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Hangi gezegen 'Kızıl Gezegen' olarak bilinir?" to listOf("Venüs", "Mars", "Jüpiter", "Satürn")),
                Language.ENGLISH to ("Which planet is known as the 'Red Planet'?" to listOf("Venus", "Mars", "Jupiter", "Saturn")),
                Language.CHINESE to ("哪个行星被称为'红色星球'？" to listOf("金星", "火星", "木星", "土星")),
                Language.SPANISH to ("¿Qué planeta es conocido como el 'Planeta Rojo'?" to listOf("Venus", "Marte", "Júpiter", "Saturno")),
                Language.ARABIC to ("أي كوكب يعرف باسم 'الكوكب الأحمر'؟" to listOf("الزهرة", "المريخ", "المشتري", "زحل")),
                Language.GERMAN to ("Welcher Planet ist als 'Roter Planet' bekannt?" to listOf("Venus", "Mars", "Jupiter", "Saturn")),
                Language.FRENCH to ("Quelle planète est connue comme la 'Planète Rouge'?" to listOf("Vénus", "Mars", "Jupiter", "Saturne")),
                Language.RUSSIAN to ("Какая планета известна как 'Красная планета'?" to listOf("Венера", "Марс", "Юпитер", "Сатурн")),
                Language.HINDI to ("किस ग्रह को 'लाल ग्रह' कहा जाता है?" to listOf("शुक्र", "मंगल", "बृहस्पति", "शनि")),
                Language.JAPANESE to ("どの惑星が'赤い惑星'として知られていますか？" to listOf("金星", "火星", "木星", "土星")),
                Language.KOREAN to ("어느 행성이 '붉은 행성'으로 알려져 있습니까?" to listOf("금성", "화성", "목성", "토성")),
                Language.PORTUGUESE to ("Qual planeta é conhecido como 'Planeta Vermelho'?" to listOf("Vênus", "Marte", "Júpiter", "Saturno")),
                Language.VIETNAMESE to ("Hành tinh nào được gọi là 'Hành tinh Đỏ'?" to listOf("Sao Kim", "Sao Hỏa", "Sao Mộc", "Sao Thổ")),
                Language.ITALIAN to ("Quale pianeta è noto come 'Pianeta Rosso'?" to listOf("Venere", "Marte", "Giove", "Saturno"))
            )
        ),
        LocalizedQuestionData(
            id = 9,
            difficulty = Difficulty.MEDIUM,
            prizeMoney = 16000,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("I. Dünya Savaşı hangi yılda başlamıştır?" to listOf("1913", "1914", "1915", "1916")),
                Language.ENGLISH to ("In which year did World War I begin?" to listOf("1913", "1914", "1915", "1916")),
                Language.CHINESE to ("第一次世界大战在哪一年开始？" to listOf("1913", "1914", "1915", "1916")),
                Language.SPANISH to ("¿En qué año comenzó la Primera Guerra Mundial?" to listOf("1913", "1914", "1915", "1916")),
                Language.ARABIC to ("في أي عام بدأت الحرب العالمية الأولى؟" to listOf("1913", "1914", "1915", "1916")),
                Language.GERMAN to ("In welchem Jahr begann der Erste Weltkrieg?" to listOf("1913", "1914", "1915", "1916")),
                Language.FRENCH to ("En quelle année la Première Guerre mondiale a-t-elle débuté?" to listOf("1913", "1914", "1915", "1916")),
                Language.RUSSIAN to ("В каком году началась Первая мировая война?" to listOf("1913", "1914", "1915", "1916")),
                Language.HINDI to ("प्रथम विश्व युद्ध किस वर्ष शुरू हुआ था?" to listOf("1913", "1914", "1915", "1916")),
                Language.JAPANESE to ("第一次世界大戦は何年に始まりましたか？" to listOf("1913", "1914", "1915", "1916")),
                Language.KOREAN to ("제1차 세계대전은 몇 년에 발발했습니까?" to listOf("1913", "1914", "1915", "1916")),
                Language.PORTUGUESE to ("Em que ano começou a Primeira Guerra Mundial?" to listOf("1913", "1914", "1915", "1916")),
                Language.VIETNAMESE to ("Chiến tranh Thế giới thứ nhất bùng nổ năm nào?" to listOf("1913", "1914", "1915", "1916")),
                Language.ITALIAN to ("In quale anno è iniziata la Prima Guerra Mondiale?" to listOf("1913", "1914", "1915", "1916"))
            )
        ),
        LocalizedQuestionData(
            id = 10,
            difficulty = Difficulty.MEDIUM,
            prizeMoney = 32000,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Hangi element periyodik tabloda 'Au' sembolü ile gösterilir?" to listOf("Gümüş", "Altın", "Bakır", "Alüminyum")),
                Language.ENGLISH to ("Which element is represented by 'Au' in the periodic table?" to listOf("Silver", "Gold", "Copper", "Aluminum")),
                Language.CHINESE to ("哪个元素在元素周期表中用'Au'表示？" to listOf("银", "金", "铜", "铝")),
                Language.SPANISH to ("¿Qué elemento está representado por 'Au' en la tabla periódica?" to listOf("Plata", "Oro", "Cobre", "Aluminio")),
                Language.ARABIC to ("أي عنصر يمثله الرمز 'Au' في الجدول الدوري؟" to listOf("الفضة", "الذهب", "النحاس", "الألمنيوم")),
                Language.GERMAN to ("Welches Element wird durch 'Au' im Periodensystem dargestellt?" to listOf("Silber", "Gold", "Kupfer", "Aluminium")),
                Language.FRENCH to ("Quel élément est représenté par 'Au' dans le tableau périodique?" to listOf("Argent", "Or", "Cuivre", "Aluminium")),
                Language.RUSSIAN to ("Какой элемент обозначается символом 'Au'?" to listOf("Серебро", "Золото", "Медь", "Алюминий")),
                Language.HINDI to ("आवर्त सारणी में 'Au' किस तत्व का प्रतीक है?" to listOf("चांदी", "सोना", "तांबा", "एल्यूमीनियम")),
                Language.JAPANESE to ("周期表で'Au'記号で表される元素はどれですか？" to listOf("銀", "金", "銅", "アルミニウム")),
                Language.KOREAN to ("주기율표에서 'Au'로 표시되는 원소는?" to listOf("은", "금", "구리", "알루미늄")),
                Language.PORTUGUESE to ("Qual elemento é representado por 'Au' na tabela periódica?" to listOf("Prata", "Ouro", "Cobre", "Alumínio")),
                Language.VIETNAMESE to ("Nguyên tố nào được biểu thị bằng ký hiệu 'Au'?" to listOf("Bạc", "Vàng", "Đồng", "Nhôm")),
                Language.ITALIAN to ("Quale elemento è rappresentato da 'Au' nella tavola periodica?" to listOf("Argento", "Oro", "Rame", "Alluminio"))
            )
        ),

        // HARD QUESTIONS (Level 11 - 13)
        LocalizedQuestionData(
            id = 11,
            difficulty = Difficulty.HARD,
            prizeMoney = 64000,
            correctAnswer = 3,
            translations = mapOf(
                Language.TURKISH to ("Dünya'nın en büyük okyanusu hangisidir?" to listOf("Atlas", "Hint", "Arktik", "Pasifik")),
                Language.ENGLISH to ("What is the largest ocean on Earth?" to listOf("Atlantic", "Indian", "Arctic", "Pacific")),
                Language.CHINESE to ("地球上最大的大洋是什么？" to listOf("大西洋", "印度洋", "北冰洋", "太平洋")),
                Language.SPANISH to ("¿Cuál es el océano más grande de la Tierra?" to listOf("Atlántico", "Índico", "Ártico", "Pacífico")),
                Language.ARABIC to ("ما هو أكبر محيط في العالم؟" to listOf("الأطلسي", "الهندي", "المتجمد الشمالي", "الهادئ")),
                Language.GERMAN to ("Was ist der größte Ozean der Erde?" to listOf("Atlantik", "Indischer", "Arktischer", "Pazifik")),
                Language.FRENCH to ("Quel est le plus grand océan de la Terre?" to listOf("Atlantique", "Indien", "Arctique", "Pacifique")),
                Language.RUSSIAN to ("Какой океан самый большой на Земле?" to listOf("Атлантический", "Индийский", "Северный Ледовитый", "Тихий")),
                Language.HINDI to ("पृथ्वी का सबसे बड़ा महासागर कौन सा है?" to listOf("अटलांटिक", "हिंद", "आर्कटिक", "प्रशांत")),
                Language.JAPANESE to ("地球上で最も大きな海洋は何ですか？" to listOf("大西洋", "インド洋", "北極海", "太平洋")),
                Language.KOREAN to ("지구에서 가장 큰 대양은?" to listOf("대서양", "인도양", "북극해", "태평양")),
                Language.PORTUGUESE to ("Qual é o maior oceano da Terra?" to listOf("Atlântico", "Índico", "Ártico", "Pacífico")),
                Language.VIETNAMESE to ("Đại dương lớn nhất trên Trái Đất là gì?" to listOf("Đại Tây Dương", "Ấn Độ Dương", "Bắc Băng Dương", "Thái Bình Dương")),
                Language.ITALIAN to ("Qual è l'oceano più grande della Terra?" to listOf("Atlantico", "Indiano", "Artico", "Pacifico"))
            )
        ),
        LocalizedQuestionData(
            id = 12,
            difficulty = Difficulty.HARD,
            prizeMoney = 125000,
            correctAnswer = 2,
            translations = mapOf(
                Language.TURKISH to ("II. Dünya Savaşı hangi yılda sona ermiştir?" to listOf("1943", "1944", "1945", "1946")),
                Language.ENGLISH to ("In which year did World War II end?" to listOf("1943", "1944", "1945", "1946")),
                Language.CHINESE to ("第二次世界大战在哪一年结束？" to listOf("1943", "1944", "1945", "1946")),
                Language.SPANISH to ("¿En qué año terminó la Segunda Guerra Mundial?" to listOf("1943", "1944", "1945", "1946")),
                Language.ARABIC to ("في أي عام انتهت الحرب العالمية الثانية؟" to listOf("1943", "1944", "1945", "1946")),
                Language.GERMAN to ("In welchem Jahr endete der Zweite Weltkrieg?" to listOf("1943", "1944", "1945", "1946")),
                Language.FRENCH to ("En quelle année la Seconde Guerre mondiale a-t-elle pris fin?" to listOf("1943", "1944", "1945", "1946")),
                Language.RUSSIAN to ("В каком году закончилась Вторая мировая война?" to listOf("1943", "1944", "1945", "1946")),
                Language.HINDI to ("द्वितीय विश्व युद्ध किस वर्ष समाप्त हुआ تھا?" to listOf("1943", "1944", "1945", "1946")),
                Language.JAPANESE to ("第二次世界大戦は何年に終結しましたか？" to listOf("1943", "1944", "1945", "1946")),
                Language.KOREAN to ("제2차 세계대전은 몇 년에 종전되었습니까?" to listOf("1943", "1944", "1945", "1946")),
                Language.PORTUGUESE to ("Em que ano terminou a Segunda Guerra Mundial?" to listOf("1943", "1944", "1945", "1946")),
                Language.VIETNAMESE to ("Chiến tranh Thế giới thứ hai kết thúc năm nào?" to listOf("1943", "1944", "1945", "1946")),
                Language.ITALIAN to ("In quale anno è terminata la Seconda Guerra Mondiale?" to listOf("1943", "1944", "1945", "1946"))
            )
        ),
        LocalizedQuestionData(
            id = 13,
            difficulty = Difficulty.HARD,
            prizeMoney = 250000,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Güneş Sistemi'nin en büyük gezegeni hangisidir?" to listOf("Satürn", "Jüpiter", "Uranüs", "Neptün")),
                Language.ENGLISH to ("Which planet is the largest in the Solar System?" to listOf("Saturn", "Jupiter", "Uranus", "Neptune")),
                Language.CHINESE to ("太阳系中最大的行星是哪个？" to listOf("土星", "木星", "天王星", "海王星")),
                Language.SPANISH to ("¿Qué planeta es el más grande del Sistema Solar?" to listOf("Saturno", "Júpiter", "Urano", "Neptuno")),
                Language.ARABIC to ("ما هو أكبر كوكب في المجموعة الشمسية؟" to listOf("زحل", "المشتري", "أورانوس", "نبتون")),
                Language.GERMAN to ("Welcher Planet ist der größte im Sonnensystem?" to listOf("Saturn", "Jupiter", "Uranus", "Neptun")),
                Language.FRENCH to ("Quelle planète est la plus grande du Système solaire?" to listOf("Saturne", "Jupiter", "Uranus", "Neptune")),
                Language.RUSSIAN to ("Какая планета самая большая в Солнечной системе?" to listOf("Сатурн", "Юпитер", "Уран", "Нептун")),
                Language.HINDI to ("सौर मंडल का सबसे बड़ा ग्रह कौन सा है?" to listOf("शनि", "बृहस्पति", "अरुण", "वरुण")),
                Language.JAPANESE to ("太陽系で最も大きな惑星はどれですか？" to listOf("土星", "木星", "天王星", "海王星")),
                Language.KOREAN to ("태양계에서 가장 큰 행성은?" to listOf("토성", "목성", "천왕성", "해왕성")),
                Language.PORTUGUESE to ("Qual planeta é o maior do Sistema Solar?" to listOf("Saturno", "Júpiter", "Urano", "Neptuno")),
                Language.VIETNAMESE to ("Hành tinh nào lớn nhất trong Hệ Mặt Trời?" to listOf("Sao Thổ", "Sao Mộc", "Sao Thiên Vương", "Sao Hải Vương")),
                Language.ITALIAN to ("Qual è il pianeta più grande del Sistema Solare?" to listOf("Saturno", "Giove", "Urano", "Nettuno"))
            )
        ),

        // EXPERT QUESTIONS (Level 14 - 15)
        LocalizedQuestionData(
            id = 14,
            difficulty = Difficulty.EXPERT,
            prizeMoney = 500000,
            correctAnswer = 2,
            translations = mapOf(
                Language.TURKISH to ("İlk insan Ay'a hangi yılda ayak basmıştır?" to listOf("1967", "1968", "1969", "1970")),
                Language.ENGLISH to ("In which year did the first human walk on the Moon?" to listOf("1967", "1968", "1969", "1970")),
                Language.CHINESE to ("人类在哪一年首次登月？" to listOf("1967", "1968", "1969", "1970")),
                Language.SPANISH to ("¿En qué año caminó el primer humano en la Luna?" to listOf("1967", "1968", "1969", "1970")),
                Language.ARABIC to ("في أي عام هبط أول إنسان على سطح القمر؟" to listOf("1967", "1968", "1969", "1970")),
                Language.GERMAN to ("In welchem Jahr betrat der erste Mensch den Mond?" to listOf("1967", "1968", "1969", "1970")),
                Language.FRENCH to ("En quelle année le premier être humain a-t-il marché sur la Lune?" to listOf("1967", "1968", "1969", "1970")),
                Language.RUSSIAN to ("В каком году человек впервые ступил на Луну?" to listOf("1967", "1968", "1969", "1970")),
                Language.HINDI to ("पहला इंसान किस वर्ष चंद्रमा पर चला था?" to listOf("1967", "1968", "1969", "1970")),
                Language.JAPANESE to ("人類が初めて月に降り立ったのは何年ですか？" to listOf("1967", "1968", "1969", "1970")),
                Language.KOREAN to ("인류가 처음 달에 착륙한 해는?" to listOf("1967", "1968", "1969", "1970")),
                Language.PORTUGUESE to ("Em que ano o primeiro humano pisou na Lua?" to listOf("1967", "1968", "1969", "1970")),
                Language.VIETNAMESE to ("Con người đầu tiên đặt chân lên Mặt Trăng năm nào?" to listOf("1967", "1968", "1969", "1970")),
                Language.ITALIAN to ("In quale anno il primo uomo ha camminato sulla Luna?" to listOf("1967", "1968", "1969", "1970"))
            )
        ),
        LocalizedQuestionData(
            id = 15,
            difficulty = Difficulty.EXPERT,
            prizeMoney = 1000000,
            correctAnswer = 1,
            translations = mapOf(
                Language.TURKISH to ("Hangi element periyodik tabloda 'H' sembolü ile gösterilir?" to listOf("Helyum", "Hidrojen", "Lityum", "Berilyum")),
                Language.ENGLISH to ("Which element is represented by 'H' in the periodic table?" to listOf("Helium", "Hydrogen", "Lithium", "Beryllium")),
                Language.CHINESE to ("哪个元素在元素周期表中用'H'表示？" to listOf("氦", "氢", "锂", "铍")),
                Language.SPANISH to ("¿Qué elemento está representado por 'H' en la tabla periódica?" to listOf("Helio", "Hidrógeno", "Litio", "Berilio")),
                Language.ARABIC to ("أي عنصر يمثله الرمز 'H' في الجدول الدوري؟" to listOf("الهيليوم", "الهيدروجين", "الليثيوم", "البيريليوم")),
                Language.GERMAN to ("Welches Element wird durch 'H' im Periodensystem dargestellt?" to listOf("Helium", "Wasserstoff", "Lithium", "Beryllium")),
                Language.FRENCH to ("Quel élément est représenté par 'H' dans le tableau périodique?" to listOf("Hélium", "Hydrogène", "Lithium", "Béryllium")),
                Language.RUSSIAN to ("Какой элемент обозначается символом 'H'?" to listOf("Гелий", "Водород", "Литий", "Бериллий")),
                Language.HINDI to ("आवर्त सारणी में 'H' किस तत्व का प्रतीक है?" to listOf("हीलियम", "हाइड्रोजन", "लिथियम", "बेरिलियम")),
                Language.JAPANESE to ("周期表で'H'記号で表される元素はどれですか？" to listOf("ヘリウム", "水素", "リチウム", "ベリリウム")),
                Language.KOREAN to ("주기율표에서 'H'로 표시되는 원소는?" to listOf("헬륨", "수소", "리튬", "베릴륨")),
                Language.PORTUGUESE to ("Qual elemento é representado por 'H' na tabela periódica?" to listOf("Hélio", "Hidrogênio", "Lítio", "Berílio")),
                Language.VIETNAMESE to ("Nguyên tố nào có ký hiệu 'H' trong bảng tuần hoàn?" to listOf("Heli", "Hiđrô", "Liti", "Beri")),
                Language.ITALIAN to ("Quale elemento è rappresentato da 'H' nella tavola periodica?" to listOf("Elio", "Idrogeno", "Litio", "Berillio"))
            )
        )
    )

    fun getGameQuestions(language: Language = Language.TURKISH): List<Question> {
        return rawQuestions.mapIndexed { index, data ->
            val prize = if (index < prizeSteps.size) prizeSteps[index] else data.prizeMoney
            val fallback = data.translations[Language.TURKISH] ?: ("Soru" to listOf("A", "B", "C", "D"))
            val (qText, options) = data.translations[language] ?: fallback
            Question(
                id = data.id,
                question = qText,
                options = options,
                correctAnswer = data.correctAnswer,
                difficulty = data.difficulty,
                prizeMoney = prize
            )
        }
    }

    fun getTotalQuestions(): Int = rawQuestions.size
}
