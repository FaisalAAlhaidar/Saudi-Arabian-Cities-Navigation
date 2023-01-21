import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionaries {
    public Map<String, Integer> map = new HashMap<>();
    public Map<Integer, String> rev = new HashMap<>();
    public Map<String, List<String>> RegionCity = new HashMap<>();
    public Map<String, String> RegionCityRev = new HashMap<>();
    public Map<String, Pair> CityCoordinates = new HashMap<>();

    public Dictionaries() {
        map.put("الرياض", 0);
        map.put("الدرعية", 1);
        map.put("الخرج", 2);
        map.put("الدوادمي", 3);
        map.put("المجمعة", 4);
        map.put("القويعية", 5);
        map.put("وادي الدواسر", 6);
        map.put("الأفلاج", 7);
        map.put("الزلفي", 8);
        map.put("شقراء", 9);
        map.put("حوطة بني تميم", 10);
        map.put("عفيف", 11);
        map.put("السليل", 12);
        map.put("ضرما", 13);
        map.put("المزاحمية", 14);
        map.put("رماح", 15);
        map.put("ثادق", 16);
        map.put("حريملاء", 17);
        map.put("الحريق", 18);
        map.put("الغاط", 19);
        map.put("مرات", 20);
        map.put("الدلم", 21);
        map.put("الرين", 22);
        map.put("مكة المكرمة", 23);
        map.put("جدة", 24);
        map.put("الطائف", 25);
        map.put("القنفذة", 26);
        map.put("الليث", 27);
        map.put("رابغ", 28);
        map.put("الجموم", 29);
        map.put("خليص", 30);
        map.put("الكامل", 31);
        map.put("الخرمة", 32);
        map.put("رنية", 33);
        map.put("تربة", 34);
        map.put("بحرة", 35);
        map.put("الموية", 36);
        map.put("ميسان", 37);
        map.put("العرضيات", 38);
        map.put("أضم", 39);
        map.put("المدينة المنورة", 40);
        map.put("ينبع", 41);
        map.put("العلا", 42);
        map.put("المهد", 43);
        map.put("بدر", 44);
        map.put("خيبر", 45);
        map.put("الحناكية", 46);
        map.put("وادي الفرع", 47);
        map.put("العيص", 48);
        map.put("بريدة", 49);
        map.put("القرعاء", 50);
        map.put("شرى", 51);/* make sure */
        map.put("عنيزة", 52);
        map.put("الرس", 53);
        map.put("المذنب", 54);
        map.put("الملقاء", 55);
        map.put("البكيرية", 56);
        map.put("البدائع", 57);
        map.put("الأسياح", 58);
        map.put("قبه", 59);
        map.put("البتراء", 60);
        map.put("المخرم", 61);
        map.put("رياض الخبراء", 62);
        map.put("الشماسية", 63);
        map.put("أم حزم", 64);
        map.put("النقرة", 65);
        map.put("العقلة", 66);
        map.put("ضرية", 67);
        map.put("الدمام", 68);
        map.put("الأحساء", 69);
        map.put("حفر الباطن", 70);
        map.put("الجبيل", 71);
        map.put("القطيف", 72);
        map.put("الخبر", 73);
        map.put("الخفجي", 74);
        map.put("رأس تنورة", 75);
        map.put("بقيق", 76);
        map.put("النعيرية", 77);
        map.put("أبها", 78);
        map.put("خميس مشيط", 79);
        map.put("بيشة", 80);
        map.put("النماص", 81);
        map.put("محايل", 82);
        map.put("سراة عبيدة", 83);
        map.put("تثليث", 84);
        map.put("رجال ألمع", 85);
        map.put("أحد رفيدة", 86);
        map.put("ظهران الجنوب", 87);
        map.put("بالقرن", 88);
        map.put("المجاردة", 89);
        map.put("طريب", 90);
        map.put("البرك", 91);
        map.put("بارق", 92);
        map.put("تنومة", 93);
        map.put("الحرجة", 94);
        map.put("تبوك", 95);
        map.put("الوجه", 96);
        map.put("ضباء", 97);
        map.put("تيماء", 98);
        map.put("أملج", 99);
        map.put("حقل", 100);
        map.put("البدع", 101);
        map.put("حائل", 102);/*---*/
        map.put("بقعاء", 103);
        map.put("الغزالة", 104);
        map.put("الشنان", 105);
        map.put("الشملي", 106);
        map.put("موقق", 107);
        map.put("سميراء", 108);
        map.put("الحائط", 109);
        map.put("السليمي", 110);
        map.put("عرعر", 111);
        map.put("رفحاء", 112);
        map.put("طريف", 113);
        map.put("العويقلية", 114);
        map.put("جازان", 115);
        map.put("صبياء", 116);
        map.put("أبو عريش", 117);
        map.put("صامطة", 118);
        map.put("الحرث", 119);
        map.put("ضمد", 120);
        map.put("الريث", 121);
        map.put("بيش", 122);
        map.put("فرسان", 123);
        map.put("الدائر", 124);
        map.put("أحد المسارحة", 125);
        map.put("العيدابي", 126);
        map.put("العارضة", 127);
        map.put("الدرب", 128);
        map.put("الطوال", 129);
        map.put("هروب", 130);
        map.put("فيفاء", 131);
        map.put("نجران", 132);
        map.put("شرورة", 133);
        map.put("حبونا", 134);
        map.put("بدر الجنوب", 135);
        map.put("يدمه", 136);
        map.put("ثار", 137);
        map.put("خباش", 138);
        map.put("الباحة", 139);
        map.put("بلجرشي", 140);
        map.put("المندق", 141);
        map.put("المخواة", 142);
        map.put("العقيق", 143);
        map.put("قلوة", 144);
        map.put("القرى", 145);
        map.put("بني حسن", 146);
        map.put("فرعة غامد الزناد", 147);
        map.put("الحجرة", 148);
        map.put("سكاكا", 149);
        map.put("القريات", 150);
        map.put("دومة الجندل", 151);
        map.put("طبرجل", 152);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            rev.put(entry.getValue(), entry.getKey());
        }
        String[] Regions = new String[]{"الرياض", "مكة المكرمة", "المدينة المنورة", "القصيم", "الشرقية", "عسير", "تبوك", "حائل", "الحدود الشمالية", "جازان", "نجران", "الباحة", "الجوف", "جميع المناطق"};
        for (String region : Regions) {
            RegionCity.put(region, new ArrayList<>());
        }
        for (int i = 0; i < 153; i++) {
            if (i < 23)
                RegionCity.get(Regions[0]).add(rev.get(i));
            else if (i < 40)
                RegionCity.get(Regions[1]).add(rev.get(i));
            else if (i < 49)
                RegionCity.get(Regions[2]).add(rev.get(i));
            else if (i < 68)
                RegionCity.get(Regions[3]).add(rev.get(i));
            else if (i < 78)
                RegionCity.get(Regions[4]).add(rev.get(i));
            else if (i < 95)
                RegionCity.get(Regions[5]).add(rev.get(i));
            else if (i < 102)
                RegionCity.get(Regions[6]).add(rev.get(i));
            else if (i < 111)
                RegionCity.get(Regions[7]).add(rev.get(i));
            else if (i < 115)
                RegionCity.get(Regions[8]).add(rev.get(i));
            else if (i < 132)
                RegionCity.get(Regions[9]).add(rev.get(i));
            else if (i < 139)
                RegionCity.get(Regions[10]).add(rev.get(i));
            else if (i < 149)
                RegionCity.get(Regions[11]).add(rev.get(i));
            else if (i < 152)
                RegionCity.get(Regions[12]).add(rev.get(i));
            RegionCity.get(Regions[13]).add(rev.get(i));
        }
        for (int i = 0; i < 153; i++) {
            if (i < 23)
                RegionCityRev.put(rev.get(i), Regions[0]);
            else if (i < 40)
                RegionCityRev.put(rev.get(i), Regions[1]);
            else if (i < 49)
                RegionCityRev.put(rev.get(i), Regions[2]);
            else if (i < 68)
                RegionCityRev.put(rev.get(i), Regions[3]);
            else if (i < 78)
                RegionCityRev.put(rev.get(i), Regions[4]);
            else if (i < 95)
                RegionCityRev.put(rev.get(i), Regions[5]);
            else if (i < 102)
                RegionCityRev.put(rev.get(i), Regions[6]);
            else if (i < 111)
                RegionCityRev.put(rev.get(i), Regions[7]);
            else if (i < 115)
                RegionCityRev.put(rev.get(i), Regions[8]);
            else if (i < 132)
                RegionCityRev.put(rev.get(i), Regions[9]);
            else if (i < 139)
                RegionCityRev.put(rev.get(i), Regions[10]);
            else if (i < 149)
                RegionCityRev.put(rev.get(i), Regions[11]);
            else if (i < 152)
                RegionCityRev.put(rev.get(i), Regions[12]);
        }
        CityCoordinates.put("أبها", new Pair(18.248519935416912, 42.5120227319733));
        CityCoordinates.put("تنومة", new Pair(18.92898217127703, 42.17711365174399));
        CityCoordinates.put("خميس مشيط", new Pair(18.28642492079996, 42.74724588151945));
        CityCoordinates.put("بيشة", new Pair(19.977585502074103, 42.589733064073386));
        CityCoordinates.put("النماص", new Pair(19.114409051468268, 42.15735938862138));
        CityCoordinates.put("محايل", new Pair(18.54532942963763, 42.05856059179156));
        CityCoordinates.put("سراة عبيدة", new Pair(18.098447542620576, 43.11859053620067));
        CityCoordinates.put("تثليث", new Pair(19.53767038632408, 43.50474055265659));
        CityCoordinates.put("رجال ألمع", new Pair(18.152840992683707, 42.156789799761384));
        CityCoordinates.put("أحد رفيدة", new Pair(18.212334249627087, 42.84454878892198));
        CityCoordinates.put("ظهران الجنوب", new Pair(17.66213623043711, 43.505151175263656));
        CityCoordinates.put("بالقرن", new Pair(19.57345854720246, 41.99879936856028));
        CityCoordinates.put("المجاردة", new Pair(19.130323112233846, 41.92410625048027));
        CityCoordinates.put("طريب", new Pair(18.56642404579299, 43.20772633562407));
        CityCoordinates.put("البرك", new Pair(18.20796856005907, 41.535336795397626));
        CityCoordinates.put("بارق", new Pair(18.93055596940682, 41.93005005855955));
        CityCoordinates.put("الحرجة", new Pair(17.92206452845743, 43.36883045079811));
        CityCoordinates.put("الباحة", new Pair(20.02187528174545, 41.47128512165095));
        CityCoordinates.put("بلجرشي", new Pair(19.865368872996083, 41.57921711994109));
        CityCoordinates.put("المندق", new Pair(20.108528549513316, 41.286921379514084));
        CityCoordinates.put("المخواة", new Pair(19.75581061467611, 41.43680255139735));
        CityCoordinates.put("العقيق", new Pair(20.27988385287578, 41.65189360843341));
        CityCoordinates.put("قلوة", new Pair(19.94655624173784, 41.24587224525015));
        CityCoordinates.put("بني حسن", new Pair(20.05540545012895, 41.36571387039181));
        CityCoordinates.put("الحجرة", new Pair(20.195512734158168, 41.07165812599828));
        CityCoordinates.put("نجران", new Pair(17.564943965696745, 44.228871865308186));
        CityCoordinates.put("شرورة", new Pair(17.487108866030724, 47.096199208715625));
        CityCoordinates.put("حبونا", new Pair(17.84143774611344, 44.02277392629778));
        CityCoordinates.put("بدر الجنوب", new Pair(17.882982187329905, 43.717217253062465));
        CityCoordinates.put("يدمه", new Pair(18.529558769907126, 44.22962356985035));
        CityCoordinates.put("ثار", new Pair(17.977282415162808, 44.10725334734034));
        CityCoordinates.put("خباش", new Pair(17.556436567640798, 44.745382477479374));
        CityCoordinates.put("جازان", new Pair(16.88936509079241, 42.570172982588616));
        CityCoordinates.put("صبياء", new Pair(17.154650916253523, 42.626953048994295));
        CityCoordinates.put("أبو عريش", new Pair(16.969312631502444, 42.84461663098569));
        CityCoordinates.put("صامطة", new Pair(16.60161767309971, 42.93482066760904));
        CityCoordinates.put("الحرث", new Pair(16.81505150507317, 43.15372418380985));
        CityCoordinates.put("ضمد", new Pair(17.11059940099584, 42.769345321841676));
        CityCoordinates.put("الريث", new Pair(17.617002615081365, 42.82717384531718));
        CityCoordinates.put("بيش", new Pair(17.374127474728862, 42.53661607747455));
        CityCoordinates.put("فرسان", new Pair(16.696633019597712, 42.12373053270624));
        CityCoordinates.put("الدائر", new Pair(17.339526117918137, 43.13080061818008));
        CityCoordinates.put("أحد المسارحة", new Pair(16.711730533566865, 42.953206589254066));
        CityCoordinates.put("العيدابي", new Pair(17.23775130333279, 42.93951624697837));
        CityCoordinates.put("الدرب", new Pair(17.734843731958943, 42.2661201440397));
        CityCoordinates.put("الطوال", new Pair(16.528107242798402, 42.97305016213611));
        CityCoordinates.put("هروب", new Pair(17.434944398469298, 42.885249687695286));
        CityCoordinates.put("فيفاء", new Pair(17.247159621467684, 43.106676454673575));
        CityCoordinates.put("الدمام", new Pair(26.42553761165272, 50.08659919632573));
        CityCoordinates.put("الأحساء", new Pair(25.389606761718767, 49.60093403242869));
        CityCoordinates.put("حفر الباطن", new Pair(28.378703181092135, 45.96253676887076));
        CityCoordinates.put("الجبيل", new Pair(26.963282867243326, 49.57219320676899));
        CityCoordinates.put("القطيف", new Pair(26.57707262097661, 49.99560304134727));
        CityCoordinates.put("الخبر", new Pair(26.22109601619992, 50.19663281342195));
        CityCoordinates.put("الخفجي", new Pair(28.42632691432745, 48.487954856641295));
        CityCoordinates.put("رأس تنورة", new Pair(26.769984829961803, 50.00519573630814));
        CityCoordinates.put("بقيق", new Pair(25.918314869155946, 49.668588146856806));
        CityCoordinates.put("النعيرية", new Pair(27.470002920512428, 48.48530761796492));
        CityCoordinates.put("تبوك", new Pair(28.452878257646066, 36.58682107751875));
        CityCoordinates.put("الوجه", new Pair(26.238597475236798, 36.46780681774284));
        CityCoordinates.put("ضباء", new Pair(27.34619366776047, 35.723041894043675));
        CityCoordinates.put("تيماء", new Pair(27.612245158363567, 38.51695047355109));
        CityCoordinates.put("أملج", new Pair(25.051299620705716, 37.265882009321444));
        CityCoordinates.put("حقل", new Pair(29.28665440969614, 34.945447303601405));
        CityCoordinates.put("البدع", new Pair(28.480110386540023, 35.023124719740544));
        CityCoordinates.put("حائل", new Pair(27.541309108731006, 41.714415608848434));
        CityCoordinates.put("بقعاء", new Pair(27.888759342849593, 42.413491766384574));
        CityCoordinates.put("الغزالة", new Pair(26.792468027407146, 41.32091037549169));
        CityCoordinates.put("الشنان", new Pair(27.178326981793656, 42.44447655717441));
        CityCoordinates.put("الشملي", new Pair(26.859209028002734, 40.329050524448135));
        CityCoordinates.put("موقق", new Pair(27.379230923665684, 41.17993339186198));
        CityCoordinates.put("الحائط", new Pair(25.993458144939222, 40.466637437352986));
        CityCoordinates.put("سميراء", new Pair(26.49553966824594, 42.12557311028519));
        CityCoordinates.put("السليمي", new Pair(26.280482733683982, 41.36764509447435));
        CityCoordinates.put("عرعر", new Pair(30.95881226556463, 41.060586461384275));
        CityCoordinates.put("رفحاء", new Pair(29.627405718512346, 43.518691001805415));
        CityCoordinates.put("طريف", new Pair(31.666155822761638, 38.66389231362358));
        CityCoordinates.put("العويقلية", new Pair(30.355309339172003, 42.248954386617235));
        CityCoordinates.put("سكاكا", new Pair(29.873837859189706, 40.09768696718585));
        CityCoordinates.put("القريات", new Pair(31.375813740980202, 37.32162796240342));
        CityCoordinates.put("دومة الجندل", new Pair(29.8107571442699, 39.89109948681423));
        CityCoordinates.put("طبرجل", new Pair(30.515525827755972, 38.22082537874833));
        CityCoordinates.put("بريدة", new Pair(26.360427415706635, 43.97995278916394));
        CityCoordinates.put("المخرم", new Pair(26.79019333676882, 43.22959144306668));
        CityCoordinates.put("القرعاء", new Pair(26.412279929388195, 43.757568586480886));
        CityCoordinates.put("عنيزة", new Pair(26.0909103924368, 43.987766180951844));
        CityCoordinates.put("الملقاء", new Pair(25.379914002864982, 43.97457885022777));
        CityCoordinates.put("المذنب", new Pair(25.859241384211714, 44.218595512437865));
        CityCoordinates.put("ضرية", new Pair(24.722730986752737, 42.931394063147934));
        CityCoordinates.put("رياض الخبراء", new Pair(26.054514016085204, 43.541586517008454));
        CityCoordinates.put("البتراء", new Pair(25.936105641478758, 42.94641498291178));
        CityCoordinates.put("الرس", new Pair(25.856064080805687, 43.523710266634914));
        CityCoordinates.put("البكيرية", new Pair(26.161179975801485, 43.6615543614731));
        CityCoordinates.put("البدائع", new Pair(25.98129052191144, 43.73365210881567));
        CityCoordinates.put("قبه", new Pair(27.40383676608395, 44.34442471474572));
        CityCoordinates.put("أم حزم", new Pair(25.83433865767909, 44.59156588043077));
        CityCoordinates.put("الشماسية", new Pair(26.319017363024514, 44.2561591497787));
        CityCoordinates.put("الأسياح", new Pair(26.79836559532382, 44.22423038833912));
        CityCoordinates.put("شرى", new Pair(27.266604558101896, 43.416509474627006));
        CityCoordinates.put("فرعة غامد الزناد", new Pair(19.602123918968363, 41.489410164011204));
        CityCoordinates.put("القرى", new Pair(20.242569352006075, 41.36255549735267));
        CityCoordinates.put("العارضة", new Pair(17.038930798489336, 43.05140674980647));
        CityCoordinates.put("المدينة المنورة", new Pair(24.582979959089556, 39.567277709158084));
        CityCoordinates.put("وادي الفرع", new Pair(23.311598392880406, 39.77316471047979));
        CityCoordinates.put("بدر", new Pair(23.77278688378673, 38.79709713495248));
        CityCoordinates.put("ينبع", new Pair(24.022016796523804, 38.19492832693028));
        CityCoordinates.put("العيص", new Pair(25.060047446423802, 38.115349367675236));
        CityCoordinates.put("العلا", new Pair(26.603617260131408, 37.92914131208897));
        CityCoordinates.put("العقلة", new Pair(25.830848532806435, 42.187994241675895));
        CityCoordinates.put("النقرة", new Pair(25.580735616396883, 41.440150818797925));
        CityCoordinates.put("المهد", new Pair(23.496051209864856, 40.86650521589952));
        CityCoordinates.put("خيبر", new Pair(25.685405705289632, 39.29185158217859));
        CityCoordinates.put("مكة المكرمة", new Pair(21.394318235225203, 39.857996426632525));
        CityCoordinates.put("رابغ", new Pair(22.793249129762476, 39.020275630493465));
        CityCoordinates.put("الجموم", new Pair(21.612908076083475, 39.70003510140949));
        CityCoordinates.put("خليص", new Pair(22.150708907845658, 39.33479730691997));
        CityCoordinates.put("الكامل", new Pair(22.271218902649338, 39.78488381472424));
        CityCoordinates.put("جدة", new Pair(21.484760340846336, 39.19268571022461));
        CityCoordinates.put("بحرة", new Pair(21.401318808907178, 39.46132418549477));
        CityCoordinates.put("الليث", new Pair(20.141634029626132, 40.27934659634155));
        CityCoordinates.put("القنفذة", new Pair(19.12883797990176, 41.078633128010175));
        CityCoordinates.put("الموية", new Pair(22.434350701688697, 41.743670070033495));
        CityCoordinates.put("الطائف", new Pair(21.290951129540222, 40.42765319044993));
        CityCoordinates.put("رنية", new Pair(21.26400840554798, 42.85432671919647));
        CityCoordinates.put("الخرمة", new Pair(21.92456655448648, 42.02836329130635));
        CityCoordinates.put("تربة", new Pair(21.207667856903377, 41.62230714802682));
        CityCoordinates.put("أضم", new Pair(20.422821791285138, 40.8619743987028));
        CityCoordinates.put("ميسان", new Pair(20.72826533984839, 40.8317635599085));
        CityCoordinates.put("الحناكية", new Pair(24.90652113159236, 40.533673583734675));
        CityCoordinates.put("العرضيات", new Pair(19.418050709837008, 41.75098179261641));
        CityCoordinates.put("الرياض", new Pair(24.726106733923384, 46.67940581580444));
        CityCoordinates.put("الدرعية", new Pair(24.748418581401648, 46.53512940536392));
        CityCoordinates.put("حريملاء", new Pair(25.115709687711078, 46.10350434348722));
        CityCoordinates.put("شقراء", new Pair(25.247353114303024, 45.253031023177186));
        CityCoordinates.put("مرات", new Pair(25.069011063908388, 45.46536050903534));
        CityCoordinates.put("عفيف", new Pair(23.906777075152466, 42.91227110971229));
        CityCoordinates.put("الدوادمي", new Pair(24.51662449197742, 44.41747603085192));
        CityCoordinates.put("ثادق", new Pair(25.28078901077037, 45.86824703170879));
        CityCoordinates.put("القويعية", new Pair(24.068694807676525, 45.281956502084164));
        CityCoordinates.put("المزاحمية", new Pair(24.47351562975484, 46.27242825714634));
        CityCoordinates.put("الخرج", new Pair(24.158004348935265, 47.321439284516366));
        CityCoordinates.put("الدلم", new Pair(23.977780311388056, 47.15324204040333));
        CityCoordinates.put("رماح", new Pair(25.563569415213912, 47.161345664257105));
        CityCoordinates.put("ضرما", new Pair(24.612218353427064, 46.15177076839226));
        CityCoordinates.put("المجمعة", new Pair(25.876714715119327, 45.37254482929565));
        CityCoordinates.put("الغاط", new Pair(26.030021350341066, 44.94766848740772));
        CityCoordinates.put("الزلفي", new Pair(26.30889517080217, 44.83031929110042));
        CityCoordinates.put("الرين", new Pair(23.542213210694545, 45.51561040526544));
        CityCoordinates.put("الحريق", new Pair(23.625206678259897, 46.51191816057757));
        CityCoordinates.put("حوطة بني تميم", new Pair(23.52440847707253, 46.8447855919514));
        CityCoordinates.put("الأفلاج", new Pair(22.289216138087934, 46.719276026538196));
        CityCoordinates.put("السليل", new Pair(20.465543055110484, 45.5599686039812));
        CityCoordinates.put("وادي الدواسر", new Pair(20.44966195542974, 44.844048667062076));
    }

    public Double calculateDistance(String c1, String c2) {
        if (!CityCoordinates.containsKey(c1) || !CityCoordinates.containsKey(c2))
            return -1.0;
        return Math.sqrt(Math.pow((CityCoordinates.get(c1).x - CityCoordinates.get(c2).x), 2) + Math.pow((CityCoordinates.get(c1).y - CityCoordinates.get(c2).y), 2));
    }
}
