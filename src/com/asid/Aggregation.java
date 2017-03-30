/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asid;

import info.debatty.java.stringsimilarity.Damerau;
import info.debatty.java.stringsimilarity.JaroWinkler;
import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.LongestCommonSubsequence;
import info.debatty.java.stringsimilarity.MetricLCS;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class Aggregation {
    //public static void main(String args[]){
    
    
    //}
    //String data= "{\"profiles\":[{\"government\":{\"Driving License data\":{},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"Rathnapura\",\"E-mail\":\"asela.12@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"923651824V\",\"Name\":\"Asela Darshan Buddhika\",\"Number of the house\":\"1F\",\"Profession\":\"Undergraduate\",\"Surname\":\"Priyadarshana\",\"picture\":\"http://localhost:3000/images/asela.jpg\",\"place of birth\":\"Rathnapura\",\"postal code\":\"70100\",\"secretariat division\":\"Balangoda\",\"telephone\":\"+94774592258\",\"village or city\":\"Balangoda\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5be4afe6fb226a8cb1424\"},\"education\":[{\"details\":\"Class of 2017 · BSc Engineering Honours · Integrated Computer Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Physical science · Colombo, Sri Lanka\",\"school\":\"Royal College (Colombo)\"}],\"facebook\":\"http://facebook.com/asela.darshan\",\"friends\":[],\"gender\":\"Male\",\"name\":\"Asela Priyadarshana\",\"places\":[{\"city\":\"Katubedda, Sri Lanka\",\"status\":\"Current city\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-1/c164.104.323.323/s160x160/1558597_719877614747952_5267274024535570642_n.jpg?oh=47fd5335a79afbf51f5b6f41a9a45a2b&oe=58EBE85B\",\"social links\":\"https://lk.linkedin.com/in/aselapriyadarshana(LinkedIn)\",\"work\":[{\"details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\",\"work\":\"Siplo\"},{\"details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\",\"work\":\"VEGA\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"57a5eb11fe6fb203d4cbb130\"},\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\", Mathematics\",\"school\":\"Royal College - Colombo 07\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://www.linkedin.com/in/aselapriyadarshana\",\"matched\":true,\"name\":\"Asela Priyadarshana\",\"projects\":[{\"project\":\"Rhino Mark III Robot Arm Recreation\"},{\"project\":\"Object Oriented Software Development\"},{\"project\":\"Smart Personal Digital Assistant\"},{\"project\":\"SkyLyzer\"},{\"project\":\"Smart Personal Digital Assistant\"}],\"skills\":[\"Java\",\"C++\",\"C\",\"Software Engineering\",\"Programming\",\"Computer Hardware\",\"MySQL\",\"Electronics\",\"Object Oriented Software\",\"Embedded Systems\",\"Microcontrollers\",\"Teamwork\",\"Algorithms\",\"C#\",\"HTML\",\"Matlab\",\"Object Oriented Design\",\"Data Structures\",\"Microsoft Office\",\"Visual C++\",\"PHP\",\"NodeJs\",\"Symfony\",\"Raspberry Pi\",\"JavaScript\",\"Amazon Web Services (AWS)\",\"PCB Design\",\"Arduino\",\"Atmel AVR\",\"ASP.NET\",\".NET\",\"Cross-platform Mobile app development\"]}}}]}";
    String data= "{\"profiles\":[{\"government\":{\"Driving License data\":{},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"Rathnapura\",\"E-mail\":\"asela.12@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"923651824V\",\"Name\":\"Asela Darshan Buddhika\",\"Number of the house\":\"1F\",\"Profession\":\"Undergraduate\",\"Surname\":\"Priyadarshana\",\"picture\":\"http://localhost:3000/images/asela.jpg\",\"place of birth\":\"Rathnapura\",\"postal code\":\"70100\",\"secretariat division\":\"Balangoda\",\"telephone\":\"+94774592258\",\"village or city\":\"Balangoda\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5be4afe6fb226a8cb1424\"},\"education\":[{\"details\":\"Class of 2017 · BSc Engineering Honours · Integrated Computer Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Physical science · Colombo, Sri Lanka\",\"school\":\"Royal College (Colombo)\"}],\"facebook\":\"http://facebook.com/asela.darshan\",\"friends\":[],\"gender\":\"Male\",\"name\":\"Asela Priyadarshana\",\"places\":[{\"city\":\"Katubedda, Sri Lanka\",\"status\":\"Current city\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-1/c164.104.323.323/s160x160/1558597_719877614747952_5267274024535570642_n.jpg?oh=47fd5335a79afbf51f5b6f41a9a45a2b&oe=58EBE85B\",\"social links\":\"https://lk.linkedin.com/in/aselapriyadarshana(LinkedIn)\",\"work\":[{\"details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\",\"work\":\"Siplo\"},{\"details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\",\"work\":\"VEGA\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"57a5eb11fe6fb203d4cbb130\"},\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\", Mathematics\",\"school\":\"Royal College - Colombo 07\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://www.linkedin.com/in/aselapriyadarshana\",\"matched\":true,\"name\":\"Asela Priyadarshana\",\"projects\":[{\"project\":\"Rhino Mark III Robot Arm Recreation\"},{\"project\":\"Object Oriented Software Development\"},{\"project\":\"Smart Personal Digital Assistant\"},{\"project\":\"SkyLyzer\"},{\"project\":\"Smart Personal Digital Assistant\"}],\"skills\":[\"Java\",\"C++\",\"C\",\"Software Engineering\",\"Programming\",\"Computer Hardware\",\"MySQL\",\"Electronics\",\"Object Oriented Software\",\"Embedded Systems\",\"Microcontrollers\",\"Teamwork\",\"Algorithms\",\"C#\",\"HTML\",\"Matlab\",\"Object Oriented Design\",\"Data Structures\",\"Microsoft Office\",\"Visual C++\",\"PHP\",\"NodeJs\",\"Symfony\",\"Raspberry Pi\",\"JavaScript\",\"Amazon Web Services (AWS)\",\"PCB Design\",\"Arduino\",\"Atmel AVR\",\"ASP.NET\",\".NET\",\"Cross-platform Mobile app development\"]}}}]}";
    //String y="{\"profiles\":[{\"socialMedia\":{\"linkedIn\":{\"skills\":[\"Java\",\"C++\",\"C\",\"Software Engineering\",\"Programming\",\"Computer Hardware\",\"MySQL\",\"Electronics\",\"Object Oriented Software\",\"Embedded Systems\",\"Microcontrollers\",\"Teamwork\",\"Algorithms\",\"C#\",\"HTML\",\"Matlab\",\"Object Oriented Design\",\"Data Structures\",\"Microsoft Office\",\"Visual C++\",\"PHP\",\"NodeJs\",\"Symfony\",\"Raspberry Pi\",\"JavaScript\",\"Amazon Web Services (AWS)\",\"PCB Design\",\"Arduino\",\"Atmel AVR\",\"ASP.NET\",\".NET\",\"Cross-platform Mobile app development\"],\"projects\":[{\"project\":\"Rhino Mark III Robot Arm Recreation\"},{\"project\":\"Object Oriented Software Development\"},{\"project\":\"Smart Personal Digital Assistant\"},{\"project\":\"SkyLyzer\"},{\"project\":\"Smart Personal Digital Assistant\"}],\"languages\":[\"English\",\"Sinhalese\"],\"matched\":true,\"_id\":{\"$oid\":\"57a5eb11fe6fb203d4cbb130\"},\"linkedin\":\"https://www.linkedin.com/in/aselapriyadarshana\",\"name\":\"Asela Priyadarshana\",\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\", Mathematics\",\"school\":\"Royal College - Colombo 07\"}]},\"facebook\":{\"work\":[{\"work\":\"Siplo\",\"details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\"},{\"work\":\"VEGA\",\"details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"}],\"social links\":\"https://lk.linkedin.com/in/aselapriyadarshana(LinkedIn)\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-1/c164.104.323.323/s160x160/1558597_719877614747952_5267274024535570642_n.jpg?oh=47fd5335a79afbf51f5b6f41a9a45a2b&oe=58EBE85B\",\"friends\":[],\"_id\":{\"$oid\":\"57a5be4afe6fb226a8cb1424\"},\"name\":\"Asela Priyadarshana\",\"facebook\":\"http://facebook.com/asela.darshan\",\"gender\":\"Male\",\"places\":[{\"status\":\"Current city\",\"city\":\"Katubedda, Sri Lanka\"}],\"education\":[{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Class of 2017 · BSc Engineering Honours · Integrated Computer Engineering · Moratuwa, Sri Lanka\"},{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Moratuwa, Sri Lanka\"},{\"school\":\"Royal College (Colombo)\",\"details\":\"Physical science · Colombo, Sri Lanka\"}]}},\"Aggregated Work\":[[\"Siplo\",\"VEGA\"],[\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\",\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"]],\"government\":{\"Vehicle data\":{},\"NIC data\":{\"Number of the house\":\"1F\",\"Profession\":\"Undergraduate\",\"E-mail\":\"asela.12@cse.mrt.ac.lk\",\"Civil Status\":\"Single\",\"Name\":\"Asela Darshan Buddhika\",\"picture\":\"http://localhost:3000/images/asela.jpg\",\"village or city\":\"Balangoda\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"Rathnapura\",\"place of birth\":\"Rathnapura\",\"ID\":\"923651824V\",\"secretariat division\":\"Balangoda\",\"FamilyName\":\"\",\"Surname\":\"Priyadarshana\",\"telephone\":\"+94774592258\",\"postal code\":\"70100\"},\"Driving License data\":{}},\"Aggregated Education\":[[\"University of Moratuwa - Faculty of Engineering\",\"Royal College - Colombo 07 (Colombo)\"],[\"class of 2017 ,  bsc engineering honours ,  integrated computer engineering ,  moratuwa,  sri lanka, bachelor of science (bsc), \",\"physical science ,  colombo,  sri lanka,  mathematics, \"]],\"Aggregated Names\":[\"Asela Darshan Buddhika Priyadarshana\"]}]}";
    //String z="{\"profiles\":[{\"socialMedia\":{\"linkedIn\":{\"skills\":[\"Java\",\"C++\",\"C\",\"Software Engineering\",\"Programming\",\"Computer Hardware\",\"MySQL\",\"Electronics\",\"Object Oriented Software\",\"Embedded Systems\",\"Microcontrollers\",\"Teamwork\",\"Algorithms\",\"C#\",\"HTML\",\"Matlab\",\"Object Oriented Design\",\"Data Structures\",\"Microsoft Office\",\"Visual C++\",\"PHP\",\"NodeJs\",\"Symfony\",\"Raspberry Pi\",\"JavaScript\",\"Amazon Web Services (AWS)\",\"PCB Design\",\"Arduino\",\"Atmel AVR\",\"ASP.NET\",\".NET\",\"Cross-platform Mobile app development\"],\"projects\":[{\"project\":\"Rhino Mark III Robot Arm Recreation\"},{\"project\":\"Object Oriented Software Development\"},{\"project\":\"Smart Personal Digital Assistant\"},{\"project\":\"SkyLyzer\"},{\"project\":\"Smart Personal Digital Assistant\"}],\"languages\":[\"English\",\"Sinhalese\"],\"matched\":true,\"_id\":{\"$oid\":\"57a5eb11fe6fb203d4cbb130\"},\"linkedin\":\"https://www.linkedin.com/in/aselapriyadarshana\",\"name\":\"Asela Priyadarshana\",\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\", Mathematics\",\"school\":\"Royal College - Colombo 07\"}]},\"facebook\":{\"work\":[{\"work\":\"Siplo\",\"details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\"},{\"work\":\"VEGA\",\"details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\"}],\"social links\":\"https://lk.linkedin.com/in/aselapriyadarshana(LinkedIn)\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-1/c164.104.323.323/s160x160/1558597_719877614747952_5267274024535570642_n.jpg?oh=47fd5335a79afbf51f5b6f41a9a45a2b&oe=58EBE85B\",\"friends\":[],\"_id\":{\"$oid\":\"57a5be4afe6fb226a8cb1424\"},\"name\":\"Asela Priyadarshana\",\"facebook\":\"http://facebook.com/asela.darshan\",\"gender\":\"Male\",\"places\":[{\"status\":\"Current city\",\"city\":\"Katubedda, Sri Lanka\"}],\"education\":[{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Class of 2017 · BSc Engineering Honours · Integrated Computer Engineering · Moratuwa, Sri Lanka\"},{\"school\":\"University of Moratuwa - Faculty of Engineering\",\"details\":\"Moratuwa, Sri Lanka\"},{\"school\":\"Royal College (Colombo)\",\"details\":\"Physical science · Colombo, Sri Lanka\"}]}},\"Aggregated Work\":[{\"Details\":\"Co-founder · 2015 to present · Moratuwa, Sri Lanka\",\"Company\":\"Siplo\"},{\"Details\":\"Engineering Intern · 19 October 2015 to 2 April 2016 · Maradana\",\"Company\":\"VEGA\"}],\"government\":{\"Vehicle data\":{},\"NIC data\":{\"Number of the house\":\"1F\",\"Profession\":\"Undergraduate\",\"E-mail\":\"asela.12@cse.mrt.ac.lk\",\"Civil Status\":\"Single\",\"Name\":\"Asela Darshan Buddhika\",\"picture\":\"http://localhost:3000/images/asela.jpg\",\"village or city\":\"Balangoda\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"Rathnapura\",\"place of birth\":\"Rathnapura\",\"ID\":\"923651824V\",\"secretariat division\":\"Balangoda\",\"FamilyName\":\"\",\"Surname\":\"Priyadarshana\",\"telephone\":\"+94774592258\",\"postal code\":\"70100\"},\"Driving License data\":{}},\"Aggregated Education\":[{\"Details\":\"class of 2017 ,  bsc engineering honours ,  integrated computer engineering ,  moratuwa,  sri lanka, bachelor of science (bsc), \",\"Institute\":\"University of Moratuwa - Faculty of Engineering\"},{\"Details\":\"physical science ,  colombo,  sri lanka,  mathematics, \",\"Institute\":\"Royal College - Colombo 07 (Colombo)\"}],\"Aggregated Names\":[\"Asela Darshan Buddhika Priyadarshana\"]}]}";
    String chathura= "{\"profiles\":[{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5dd57fe6fb2165069e22b\"},\"education\":[{\"details\":\"2013 to 2017 · Computer Science and Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Left in 2011 · Polonnaruwa\",\"school\":\"PL/Royal central college\"},{\"details\":\"Kalutara South, Sri Lanka\",\"school\":\"Kalutara Vidyalaya\"}],\"facebook\":\"https://www.facebook.com/siriwardana.chathura\",\"family\":[{}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Men and women\",\"languages\":[\"Sinhala\",\"English\"],\"marital_status\":\"Single\",\"name\":\"Chathura Mahanama Siriwardhane\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12976907_10204591006814208_7587934516475232131_o.jpg?oh=4ede3d176b90513e365911ee67b5e3d8&oe=59080AD6\",\"work\":[{\"details\":\"Software Engineering Intern · Mount Lavinia, Sri Lanka\",\"work\":\"Embla Software Innovation\"}]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5dd57fe6fb2165069e22b\"},\"education\":[{\"details\":\"2013 to 2017 · Computer Science and Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Left in 2011 · Polonnaruwa\",\"school\":\"PL/Royal central college\"},{\"details\":\"Kalutara South, Sri Lanka\",\"school\":\"Kalutara Vidyalaya\"}],\"facebook\":\"https://www.facebook.com/siriwardana.chathura\",\"family\":[{}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Men and women\",\"languages\":[\"Sinhala\",\"English\"],\"marital_status\":\"Single\",\"name\":\"Chathura Mahanama Siriwardhane\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12976907_10204591006814208_7587934516475232131_o.jpg?oh=4ede3d176b90513e365911ee67b5e3d8&oe=59080AD6\",\"work\":[{\"details\":\"Software Engineering Intern · Mount Lavinia, Sri Lanka\",\"work\":\"Embla Software Innovation\"}]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5e3c1fe6fb2165069e24b\"},\"education\":[{\"details\":\"2012 to 2017 · Integrated Computer Science and Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Class of 2011 · Kurunegala\",\"school\":\"Maliyadeva College\"}],\"email address\":\"chathurawidanage@gmail.com\",\"facebook\":\"https://www.facebook.com/chathura.widanage\",\"family\":[{}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Women\",\"languages\":[\"Sinhala\",\"English\"],\"marital_status\":\"Single\",\"name\":\"Chathura Widanage\",\"places\":[{\"city\":\"Moratuwa, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Kurunegala\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/10988529_1101321326560593_4288996505509639763_n.jpg?oh=a65141a8844459e34c47d1630a06845e&oe=58FFC7E7\",\"websites\":\"http://www.cwidanage.com\",\"work\":[{\"details\":\"Google Summer of Code Intern · 23 April 2016 to present\",\"work\":\"Google Summer of Code\"},{\"details\":\"Engineering Intern · 19 October 2015 to 1 April 2016 · Mount Lavania, Sri Lanka\",\"work\":\"AdroitLogic\"},{\"details\":\"Web Application Developer · January 2015 to December 2015 · Moratuwa\",\"work\":\"MoraSpirit\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"57a5c529fe6fb218a8b9fc06\"},\"awards\":[{\"award\":\"Best all round Student\",\"organisation\":\"Maliyadeva College\"},{\"award\":\"Best Chess player\",\"organisation\":\"Maliyadeva College\"},{\"award\":\"Winner of the 'Best User Friendly Application and Visual Appearance' at Google I/O Extended 2015 Hackathon\",\"organisation\":\"GSG Sri Lanka with Mobitel Sri Lanka\"},{\"award\":\"1st Runner's Up ACES Coders v5.0\",\"organisation\":\"University of Peradeniya\"},{\"award\":\"124th on the Global Rank @ IEEEXtreme 8.0\",\"organisation\":\"IEEE.org\"},{\"award\":\"2nd runner up - Fugostica 2.0\",\"organisation\":\"aiesec.org\"},{\"award\":\"Winners - Ideamart Code Ultimum 2014\",\"organisation\":\"Dialog\"},{\"award\":\"2nd Runner up - Mora Hack 2015\",\"organisation\":\"Dialog\"}],\"education\":[{\"course\":\"Bachelor of Science (BSc), Integrated computer science and engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\"G.C.E Advanced Level, Physical Sciences, Z-Score : 2.5566 | District Rank(Kurunegala) : 8 | Island Rank : 135\",\"school\":\"Maliyadeva College\"}],\"experience\":[{\"organisation\":\"AdroitLogic\",\"position\":\"Software Engineering Intern\"},{\"organisation\":\"Moraspirit\",\"position\":\"Web Developer & Designer\"},{\"organisation\":\"CSE Partner Network\",\"position\":\"Web Developer\"},{\"organisation\":\"Fiverr (Fiverr.com)\",\"position\":\"Java application developer\"},{\"organisation\":\"Fiverr (Fiverr.com)\",\"position\":\"Web developer\"},{\"organisation\":\"Thineth Software Solutions\",\"position\":\"Java Developer\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://www.linkedin.com/in/cwidanage\",\"matched\":true,\"name\":\"Chathura Widanage\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/6/005/0a7/1dd/186058a.jpg\",\"projects\":[{\"project\":\"Line Following Robot\"},{\"project\":\"Moradevans\"},{\"project\":\"Restaurant Management System\"},{\"project\":\"CSE partner network\"},{\"project\":\"Mercon\"},{\"project\":\"Multi model self driving autonomous car\"},{\"project\":\"'Remindme' - Smart digital assistant\"},{\"project\":\"SMS based automated live score board and treasure hunt for Outboundz event.\"},{\"project\":\"Nigandu\"},{\"project\":\"Multiplayer blackjack game\"},{\"project\":\"Hotel Management System\"},{\"project\":\"Vehicle Reservation System\"}],\"skills\":[\"MySQL\",\"PHP\",\"JavaScript\",\"CSS\",\"Web Development\",\"Microsoft Office\",\"Web Design\",\"HTML 5\",\"Photoshop\",\"JavaSE\",\"Java Enterprise Edition\",\"JSP\",\"CSS3\",\"Jasper Reports\",\"Sun Certified Java Programmer\",\"Dreamweaver\",\"Servlets\",\"Android Development\",\"Image Processing\",\"OpenCV\",\"Symfony\",\"Mobile Game Development\",\"HTML5\",\"Programming\",\"Java\",\"HTML\",\"C++\",\"C\",\"Software Development\",\"Linux\",\"SQL\",\"Object-Oriented Programming (OOP)\",\"Algorithms\"]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"A-\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"Full Name\":\"Chathura Harindu Wijeweera\",\"ID\":\"913394215v\",\"Name with initials\":\"C.H.Wijeweera\",\"address\":\"12, Galle rd, Matara\",\"driving licence number\":\"4568536v\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"single\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"matara\",\"E-mail\":\"chathuravije@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"913394215v\",\"Name\":\"chathura harindu\",\"Number of the house\":\"12\",\"Profession\":\"student\",\"Surname\":\"wijeweera\",\"picture\":\"chathura_3.jpg\",\"place of birth\":\"matara\",\"postal code\":\"1456\",\"score\":0,\"secretariat division\":\"matara\",\"street\":\"galle road\",\"telephone\":\"0702700123\",\"village or city\":\"matara\"},\"Vehicle data\":{\"Address\":\"12, Galle rd, Matara\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"Full Name\":\"Chathura Harindu Wijeweera\",\"NIC\":\"913394215v\",\"Name with initials\":\"C.H.Wijeweera\",\"Year of manufactured\":\"2009\",\"vehicle number\":\"NA-4569\"}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09d9265f834242aaef0c1\"},\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Class of 2010 · Matara, Sri Lanka\",\"school\":\"Rahula College\"},{\"details\":\"January 1997 to 2000 · Tangalle\",\"school\":\"Tangalle Primary School\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"}],\"facebook\":\"https://www.facebook.com/chathura.kodippili\",\"family\":[{\"name\":\"Lasith Kodippili\",\"relation\":\"Brother\"}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Men and women\",\"languages\":[\"Sinhala\",\"English\"],\"name\":\"Chathura Kodippili\",\"places\":[{\"city\":\"Katubedda, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Matara, Sri Lanka\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11707818_764606906981440_1320332375931547599_n.jpg?oh=4636fa7d4bac9ba0f99fff4caf92af2f&oe=58FD4AC1\",\"work\":[{\"details\":\"Civil Engineer Trainee · 19 October 2015 to 3 April 2016 · Malabe, Sri Lanka\",\"work\":\"International Construction Consortium\"},{\"details\":\"Chief Activity Coordinator · 9 August 2015 to 12 June 2016 · Katubedda, Sri Lanka\",\"work\":\"UoM Leos\"},{\"details\":\"Director · 10 August 2014 to 9 August 2015 · Katubedda, Sri Lanka\",\"work\":\"UoM Leos\"},{\"details\":\"Corporate Manager · March 2014 to March 2015 · Moratuwa\",\"work\":\"MoraSpirit\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a14fe6fb2172837475b\"},\"education\":[{\"course\":\"B.Sc.Engineering, Civil Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\"\",\"school\":\"Rahula College - Matara\"}],\"experience\":[{\"organisation\":\"Leo Club Of University of Moratuwa \",\"position\":\"Cheif  Activity cordinator \"},{\"organisation\":\"International Construction Consortium (pvt) Ltd.\",\"position\":\"Civil Engineering Intern\"},{\"organisation\":\"Moraspirit Initiative\",\"position\":\"Corporate Development Manager\"}],\"linkedin\":\"https://www.linkedin.com/in/chathura-kodippili\",\"matched\":true,\"name\":\"Chathura Kodippili\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAYEAAAAJDIwNzFkMzZiLTFhOGMtNDI5My04MWYxLWQ0YzczOWY5MmRlMw.jpg\",\"skills\":[\"Construction\",\"Project Management\",\"SAP 2000\",\"ETABS\",\"Microsoft Office\",\"AutoCAD\",\"Microsoft Excel\",\"English\",\"CAD\",\"Windows\",\"Photography\",\"Engineering\",\"Teamwork\",\"Civil Engineering\",\"Microsoft Word\"]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09e4865f834246048be18\"},\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"}],\"facebook\":\"https://www.facebook.com/chathura.wijeweera.7\",\"family\":[{\"name\":\"Uvindu Isuru Wijeweera\",\"relation\":\"Brother\"}],\"friends\":[],\"name\":\"Chathura Wijeweera\",\"places\":[{\"city\":\"Matara, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Matara, Sri Lanka\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13342862_1096647670400404_2220799681288308896_n.jpg?oh=1a9eba3d806c0a77816558dd97f56444&oe=58FF81EA\"},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a3cfe6fb2172837475d\"},\"education\":[{\"course\":\"Bachelor of Science (B.Sc.), Computer Science\",\"school\":\"University of Moratuwa\"},{\"course\":\"\",\"school\":\"Rahula college\"}],\"experience\":[{\"organisation\":\"VirtusaPolaris\",\"position\":\"Software Engineering Trainee\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://lk.linkedin.com/in/chathura-wijeweera\",\"matched\":true,\"name\":\"chathura wijeweera\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAApAAAAJDdlNDc5MGMwLWEwNTgtNGJhNy1iYTUwLTRiMzAzMjBhMGM1Mg.jpg\",\"skills\":[\"C\",\"Java\",\"HTML\",\"C++\",\"JavaScript\",\"Microsoft Excel\",\"Teamwork\",\"Programming\"]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"A-\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"Full Name\":\"Chathura Harindu Wijeweera\",\"ID\":\"913394215v\",\"Name with initials\":\"C.H.Wijeweera\",\"address\":\"12, Galle rd, Matara\",\"driving licence number\":\"4568536v\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"single\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"matara\",\"E-mail\":\"chathuravije@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"913394215v\",\"Name\":\"chathura harindu\",\"Number of the house\":\"12\",\"Profession\":\"student\",\"Surname\":\"wijeweera\",\"picture\":\"chathura_3.jpg\",\"place of birth\":\"matara\",\"postal code\":\"1456\",\"score\":0,\"secretariat division\":\"matara\",\"street\":\"galle road\",\"telephone\":\"0702700123\",\"village or city\":\"matara\"},\"Vehicle data\":{\"Address\":\"12, Galle rd, Matara\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"Full Name\":\"Chathura Harindu Wijeweera\",\"NIC\":\"913394215v\",\"Name with initials\":\"C.H.Wijeweera\",\"Year of manufactured\":\"2009\",\"vehicle number\":\"NA-4569\"}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09e4865f834246048be18\"},\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"}],\"facebook\":\"https://www.facebook.com/chathura.wijeweera.7\",\"family\":[{\"name\":\"Uvindu Isuru Wijeweera\",\"relation\":\"Brother\"}],\"friends\":[],\"name\":\"Chathura Wijeweera\",\"places\":[{\"city\":\"Matara, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Matara, Sri Lanka\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13342862_1096647670400404_2220799681288308896_n.jpg?oh=1a9eba3d806c0a77816558dd97f56444&oe=58FF81EA\"},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a3cfe6fb2172837475d\"},\"education\":[{\"course\":\"Bachelor of Science (B.Sc.), Computer Science\",\"school\":\"University of Moratuwa\"},{\"course\":\"\",\"school\":\"Rahula college\"}],\"experience\":[{\"organisation\":\"VirtusaPolaris\",\"position\":\"Software Engineering Trainee\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://lk.linkedin.com/in/chathura-wijeweera\",\"matched\":true,\"name\":\"chathura wijeweera\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAApAAAAJDdlNDc5MGMwLWEwNTgtNGJhNy1iYTUwLTRiMzAzMjBhMGM1Mg.jpg\",\"skills\":[\"C\",\"Java\",\"HTML\",\"C++\",\"JavaScript\",\"Microsoft Excel\",\"Teamwork\",\"Programming\"]}}}]}";
    String c="{\"profiles\":[{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5dd57fe6fb2165069e22b\"},\"education\":[{\"details\":\"2013 to 2017 · Computer Science and Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Left in 2011 · Polonnaruwa\",\"school\":\"PL/Royal central college\"},{\"details\":\"Kalutara South, Sri Lanka\",\"school\":\"Kalutara Vidyalaya\"}],\"facebook\":\"https://www.facebook.com/siriwardana.chathura\",\"family\":[{}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Men and women\",\"languages\":[\"Sinhala\",\"English\"],\"marital_status\":\"Single\",\"name\":\"Chathura Mahanama Siriwardhane\",\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/s960x960/12976907_10204591006814208_7587934516475232131_o.jpg?oh=4ede3d176b90513e365911ee67b5e3d8&oe=59080AD6\",\"work\":[{\"details\":\"Software Engineering Intern · Mount Lavinia, Sri Lanka\",\"work\":\"Embla Software Innovation\"}]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a5e3c1fe6fb2165069e24b\"},\"education\":[{\"details\":\"2012 to 2017 · Integrated Computer Science and Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Class of 2011 · Kurunegala\",\"school\":\"Maliyadeva College\"}],\"email address\":\"chathurawidanage@gmail.com\",\"facebook\":\"https://www.facebook.com/chathura.widanage\",\"family\":[{}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Women\",\"languages\":[\"Sinhala\",\"English\"],\"marital_status\":\"Single\",\"name\":\"Chathura Widanage\",\"places\":[{\"city\":\"Moratuwa, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Kurunegala\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/10988529_1101321326560593_4288996505509639763_n.jpg?oh=a65141a8844459e34c47d1630a06845e&oe=58FFC7E7\",\"websites\":\"http://www.cwidanage.com\",\"work\":[{\"details\":\"Google Summer of Code Intern · 23 April 2016 to present\",\"work\":\"Google Summer of Code\"},{\"details\":\"Engineering Intern · 19 October 2015 to 1 April 2016 · Mount Lavania, Sri Lanka\",\"work\":\"AdroitLogic\"},{\"details\":\"Web Application Developer · January 2015 to December 2015 · Moratuwa\",\"work\":\"MoraSpirit\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"57a5c529fe6fb218a8b9fc06\"},\"awards\":[{\"award\":\"Best all round Student\",\"organisation\":\"Maliyadeva College\"},{\"award\":\"Best Chess player\",\"organisation\":\"Maliyadeva College\"},{\"award\":\"Winner of the 'Best User Friendly Application and Visual Appearance' at Google I/O Extended 2015 Hackathon\",\"organisation\":\"GSG Sri Lanka with Mobitel Sri Lanka\"},{\"award\":\"1st Runner's Up ACES Coders v5.0\",\"organisation\":\"University of Peradeniya\"},{\"award\":\"124th on the Global Rank @ IEEEXtreme 8.0\",\"organisation\":\"IEEE.org\"},{\"award\":\"2nd runner up - Fugostica 2.0\",\"organisation\":\"aiesec.org\"},{\"award\":\"Winners - Ideamart Code Ultimum 2014\",\"organisation\":\"Dialog\"},{\"award\":\"2nd Runner up - Mora Hack 2015\",\"organisation\":\"Dialog\"}],\"education\":[{\"course\":\"Bachelor of Science (BSc), Integrated computer science and engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\"G.C.E Advanced Level, Physical Sciences, Z-Score : 2.5566 | District Rank(Kurunegala) : 8 | Island Rank : 135\",\"school\":\"Maliyadeva College\"}],\"experience\":[{\"organisation\":\"AdroitLogic\",\"position\":\"Software Engineering Intern\"},{\"organisation\":\"Moraspirit\",\"position\":\"Web Developer & Designer\"},{\"organisation\":\"CSE Partner Network\",\"position\":\"Web Developer\"},{\"organisation\":\"Fiverr (Fiverr.com)\",\"position\":\"Java application developer\"},{\"organisation\":\"Fiverr (Fiverr.com)\",\"position\":\"Web developer\"},{\"organisation\":\"Thineth Software Solutions\",\"position\":\"Java Developer\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://www.linkedin.com/in/cwidanage\",\"matched\":true,\"name\":\"Chathura Widanage\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAi7AAAAJDE4ODBlZWQ2LTBlOGMtNDQ1NC1iMGI5LTc4YjQwMzc5MDEyMw.jpg\",\"projects\":[{\"project\":\"Line Following Robot\"},{\"project\":\"Moradevans\"},{\"project\":\"Restaurant Management System\"},{\"project\":\"CSE partner network\"},{\"project\":\"Mercon\"},{\"project\":\"Multi model self driving autonomous car\"},{\"project\":\"'Remindme' - Smart digital assistant\"},{\"project\":\"SMS based automated live score board and treasure hunt for Outboundz event.\"},{\"project\":\"Nigandu\"},{\"project\":\"Multiplayer blackjack game\"},{\"project\":\"Hotel Management System\"},{\"project\":\"Vehicle Reservation System\"}],\"skills\":[\"MySQL\",\"PHP\",\"JavaScript\",\"CSS\",\"Web Development\",\"Microsoft Office\",\"Web Design\",\"HTML 5\",\"Photoshop\",\"JavaSE\",\"Java Enterprise Edition\",\"JSP\",\"CSS3\",\"Jasper Reports\",\"Sun Certified Java Programmer\",\"Dreamweaver\",\"Servlets\",\"Android Development\",\"Image Processing\",\"OpenCV\",\"Symfony\",\"Mobile Game Development\",\"HTML5\",\"Programming\",\"Java\",\"HTML\",\"C++\",\"C\",\"Software Development\",\"Linux\",\"SQL\",\"Object-Oriented Programming (OOP)\",\"Algorithms\"]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"Full Name\":\"Widanalage Chathura Widanage\",\"ID\":\"922290695v\",\"Name with initials\":\"W.C.Widanage\",\"address\":\"75/1, Ihalagama Rd, Pilessa\",\"driving licence number\":\"B1074731\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"8/16/1992 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"chathurawidanage@gmail.com\",\"FamilyName\":\"Widanalage\",\"ID\":\"922290695v\",\"Name\":\"Chathura\",\"Number of the house\":\"75/1\",\"Profession\":\"Student\",\"Surname\":\"Widanage\",\"picture\":\"chathura_4.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60058\",\"score\":0,\"secretariat division\":\"Mawathagama\",\"street\":\"Ihalagama Road\",\"telephone\":\"729624605\",\"village or city\":\"Pilessa\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09d9265f834242aaef0c1\"},\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Class of 2010 · Matara, Sri Lanka\",\"school\":\"Rahula College\"},{\"details\":\"January 1997 to 2000 · Tangalle\",\"school\":\"Tangalle Primary School\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"}],\"facebook\":\"https://www.facebook.com/chathura.kodippili\",\"family\":[{\"name\":\"Lasith Kodippili\",\"relation\":\"Brother\"}],\"friends\":[],\"gender\":\"Male\",\"interested in\":\"Men and women\",\"languages\":[\"Sinhala\",\"English\"],\"name\":\"Chathura Kodippili\",\"places\":[{\"city\":\"Katubedda, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Matara, Sri Lanka\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11707818_764606906981440_1320332375931547599_n.jpg?oh=4636fa7d4bac9ba0f99fff4caf92af2f&oe=58FD4AC1\",\"work\":[{\"details\":\"Civil Engineer Trainee · 19 October 2015 to 3 April 2016 · Malabe, Sri Lanka\",\"work\":\"International Construction Consortium\"},{\"details\":\"Chief Activity Coordinator · 9 August 2015 to 12 June 2016 · Katubedda, Sri Lanka\",\"work\":\"UoM Leos\"},{\"details\":\"Director · 10 August 2014 to 9 August 2015 · Katubedda, Sri Lanka\",\"work\":\"UoM Leos\"},{\"details\":\"Corporate Manager · March 2014 to March 2015 · Moratuwa\",\"work\":\"MoraSpirit\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a14fe6fb2172837475b\"},\"education\":[{\"course\":\"B.Sc.Engineering, Civil Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\"\",\"school\":\"Rahula College - Matara\"}],\"experience\":[{\"organisation\":\"Leo Club Of University of Moratuwa \",\"position\":\"Cheif  Activity cordinator \"},{\"organisation\":\"International Construction Consortium (pvt) Ltd.\",\"position\":\"Civil Engineering Intern\"},{\"organisation\":\"Moraspirit Initiative\",\"position\":\"Corporate Development Manager\"}],\"linkedin\":\"https://www.linkedin.com/in/chathura-kodippili\",\"matched\":true,\"name\":\"Chathura Kodippili\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAYEAAAAJDIwNzFkMzZiLTFhOGMtNDI5My04MWYxLWQ0YzczOWY5MmRlMw.jpg\",\"skills\":[\"Construction\",\"Project Management\",\"SAP 2000\",\"ETABS\",\"Microsoft Office\",\"AutoCAD\",\"Microsoft Excel\",\"English\",\"CAD\",\"Windows\",\"Photography\",\"Engineering\",\"Teamwork\",\"Civil Engineering\",\"Microsoft Word\"]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"A-\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"Full Name\":\"Chathura Harindu Wijeweera\",\"ID\":\"913394215v\",\"Name with initials\":\"C.H.Wijeweera\",\"address\":\"12, Galle rd, Matara\",\"driving licence number\":\"4568536v\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"single\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"District\":\"matara\",\"E-mail\":\"chathuravije@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"913394215v\",\"Name\":\"chathura harindu\",\"Number of the house\":\"12\",\"Profession\":\"student\",\"Surname\":\"wijeweera\",\"picture\":\"chathura_3.jpg\",\"place of birth\":\"matara\",\"postal code\":\"1456\",\"score\":0,\"secretariat division\":\"matara\",\"street\":\"galle road\",\"telephone\":\"0702700123\",\"village or city\":\"matara\"},\"Vehicle data\":{\"Address\":\"12, Galle rd, Matara\",\"Date of birth\":\"12/30/1992 12:00:00 AM\",\"Full Name\":\"Chathura Harindu Wijeweera\",\"NIC\":\"913394215v\",\"Name with initials\":\"C.H.Wijeweera\",\"Year of manufactured\":\"2009\",\"vehicle number\":\"NA-4569\"}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09e4865f834246048be18\"},\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"},{\"details\":\"Matara, Sri Lanka\",\"school\":\"Rahula College\"}],\"facebook\":\"https://www.facebook.com/chathura.wijeweera.7\",\"family\":[{\"name\":\"Uvindu Isuru Wijeweera\",\"relation\":\"Brother\"}],\"friends\":[],\"name\":\"Chathura Wijeweera\",\"places\":[{\"city\":\"Matara, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Matara, Sri Lanka\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13342862_1096647670400404_2220799681288308896_n.jpg?oh=1a9eba3d806c0a77816558dd97f56444&oe=58FF81EA\"},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a3cfe6fb2172837475d\"},\"education\":[{\"course\":\"Bachelor of Science (B.Sc.), Computer Science\",\"school\":\"University of Moratuwa\"},{\"course\":\"\",\"school\":\"Rahula college\"}],\"experience\":[{\"organisation\":\"VirtusaPolaris\",\"position\":\"Software Engineering Trainee\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://lk.linkedin.com/in/chathura-wijeweera\",\"matched\":true,\"name\":\"chathura wijeweera\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAApAAAAJDdlNDc5MGMwLWEwNTgtNGJhNy1iYTUwLTRiMzAzMjBhMGM1Mg.jpg\",\"skills\":[\"C\",\"Java\",\"HTML\",\"C++\",\"JavaScript\",\"Microsoft Excel\",\"Teamwork\",\"Programming\"]}}}]}";
    //String_Comparison s= new String_Comparison();
    String buddhika ="{\"profiles\":[{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"11/26/1991 12:00:00 AM\",\"Full Name\":\"Kasun Buddhika Dissanayake\",\"ID\":\"913312503v\",\"Name with initials\":\"K.B.Dissanayake\",\"address\":\"256,Etaweeragollewa\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"11/26/1991 12:00:00 AM\",\"District\":\"Anuradhapura\",\"E-mail\":\"kasundissanayake.12@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"913312503v\",\"Name\":\"Kasun Buddhika\",\"Number of the house\":\"256\",\"Profession\":\"undergraduate\",\"Surname\":\"Dissanayake\",\"picture\":\"buddhika_2.jpg\",\"place of birth\":\"Anuradhapura\",\"postal code\":\"50518\",\"score\":0,\"secretariat division\":\"Madawachchiya\",\"telephone\":\"711538675\",\"village or city\":\"Etaweeragollewa\"}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"57a59557fe6fb21f7402cfb2\"},\"education\":[{\"details\":\"2012 to 2016 · Computer Engineering · Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Class of 2010 · Kurunegala\",\"school\":\"Maliyadeva College\"}],\"facebook\":\"https://www.facebook.com/b.kit.s\",\"family\":[{\"name\":\"Anushka Dilrukshi\",\"relation\":\"Cousin\"},{\"name\":\"Prasadini Perera\",\"relation\":\"Family member\"}],\"friends\":[],\"gender\":\"Male\",\"mobile\":\"071 041 1762\",\"name\":\"Buddhika Senevirathne\",\"places\":[{\"city\":\"Kurunegala\",\"status\":\"Current city\"},{\"city\":\"Kurunegala\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent.fcmb3-1.fna.fbcdn.net/v/t1.0-9/14291775_1065488400225658_2905138646593394874_n.jpg?oh=a5e304e486042c8eb32712b01f251dfa&oe=59045272\",\"work\":[{\"details\":\"Trainee Software Engineer · October 2015 to April 2016 · Colombo, Sri Lanka\",\"work\":\"Ellipsis\"},{\"details\":\"Article Writer · Moratuwa\",\"work\":\"MoraSpirit\"}]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"B-\",\"Date of birth\":\"2/4/1991 12:00:00 AM\",\"Full Name\":\"Buddhika Jayawardhana\",\"ID\":\"912367321v\",\"Name with initials\":\"K.P.B.Jayawardhana\",\"address\":\"32C, Kandy Rd, Peradeniya\",\"driving licence number\":\"B3228766\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"single\",\"Date of birth\":\"2/4/1991 12:00:00 AM\",\"District\":\"Kandy\",\"E-mail\":\"BuddhikaJ.12@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"912367321v\",\"Name\":\"Buddhika\",\"Number of the house\":\"32C\",\"Profession\":\"CEO\",\"Surname\":\"Jayawardhana\",\"picture\":\"buddhika_3.jpg\",\"place of birth\":\"Kandy\",\"postal code\":\"1254\",\"score\":0,\"secretariat division\":\"Kandy\",\"street\":\"Kandy Rd\",\"telephone\":\"0778299932\",\"village or city\":\"Peradeniya\"}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09ea965f834246048be1a\"},\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Department of Computer Science & Engineering\"},{\"details\":\"Left in 2010 · Anuradhapura\",\"school\":\"Anuradhapura Central College\"},{\"details\":\"Colombo, Sri Lanka\",\"school\":\"University of Moratuwa\"}],\"email\":\"kasun.bdn@gmail.com\",\"facebook\":\"https://www.facebook.com/Kasunbdn\",\"family\":[{\"name\":\"Harsha Dulshan Dissanayake\",\"relation\":\"Brother\"}],\"friends\":[],\"interested in\":\"Men and women\",\"name\":\"Kasun Buddhika Dissanayake\",\"places\":[{\"city\":\"Moratuwa, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Madawachchiya, Sri Lanka\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15337554_1280086388731512_5396959062360735216_n.jpg?oh=4ffd247b78fb3e71020341d2e681c227&oe=59457A6A\",\"social links\":\"kasunbdn(Twitter)\",\"work\":[{\"work\":\"Eyepax I T Consulting Private Limited\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a6bfe6fb2172837475f\"},\"education\":[{\"course\":\"Bachelor of Science (BSc), Computer Science and Engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\"Physical Science\",\"school\":\"Anuradhapura Central College\"},{\"course\":\"\",\"school\":\"Anuradhapura Central Collage\"}],\"experience\":[{\"organisation\":\"University of Moratuwa\",\"position\":\"Computer Science & Engineering Undergraduate\"},{\"organisation\":\"Self-Employed\",\"position\":\"Android Developer\"},{\"organisation\":\"Eyepax IT Consulting (Pvt) Ltd.\",\"position\":\"Software Engineering Intern\"}],\"languages\":[\"English\",\"Sinhalese\"],\"linkedin\":\"https://lk.linkedin.com/in/kasundissanayake\",\"matched\":true,\"name\":\"Kasun Buddhika Dissanayake\",\"organisations\":[\"Rotaract Club of University of Moratuwa\",\"IEEE Student Branch, University of Moratuwa\"],\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAkLAAAAJDRjNWQ3ODRiLWY2OWMtNDE1Zi04ZDlhLWVjNDZkMzdmODQ3Nw.jpg\",\"projects\":[{\"project\":\"Predicting learner performance in MOOCs\"},{\"project\":\"Easy Equations : Linear Equation Solver\"},{\"project\":\"Floating Polygons - Crowdsourcing touch screen inputs for a contextual data model\"},{\"project\":\"Ride Reservation & Driver Management System for 3Wheelers' Association\"},{\"project\":\"Ball Picking and Line Following Robot\"},{\"project\":\"Process Scheduling Simulator\"},{\"project\":\"Propeller LED Display\"},{\"project\":\"Are You Ready? 2013\"},{\"project\":\"Quadratic Equation Solver\"},{\"project\":\"Tic Tac Toe\"},{\"project\":\"Hospital Management System\"}],\"skills\":[\"Java\",\"Android\",\"MySQL\",\"C\",\"C++\",\"Algorithms\",\"OOP\",\"PHP\",\"HTML\",\"CSS\",\"Git\",\"Data Structures\",\"MongoDB\",\"Arduino\",\"C#\",\"ASP.NET Web API\",\"JavaScript\",\"Node.js\",\"SQL Server Management Studio\",\"Microsoft SQL Server\",\"WordPress\",\"Prestashop\",\"Unity3D\",\"Symfony\",\"Bootstrap\",\"Python\",\"jQuery\",\"AJAX\",\"Microsoft Office\",\"Computer Science\",\"JIRA\",\"Data Mining\",\"R\",\"Windows\",\"Ubuntu\",\"Adobe Photoshop\"]}}},{\"government\":{\"Driving License data\":{},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"3/2/1991 12:00:00 AM\",\"District\":\"Kurunegala\",\"E-mail\":\"kithmini.12@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"910620169v\",\"Name\":\"Buddhika Kithmini\",\"Number of the house\":\"54\",\"Profession\":\"Undergraduate\",\"Surname\":\"Senevirathne\",\"picture\":\"kithmini.jpg\",\"place of birth\":\"Kurunegala\",\"postal code\":\"60000\",\"score\":0,\"secretariat division\":\"Mallawapitiya\",\"street\":\"Gajaba Mawatha\",\"telephone\":\"710411762\",\"village or city\":\"Samanpura\"},\"Vehicle data\":{}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09ee965f834246048be1c\"},\"education\":[{\"details\":\"Matara, Sri Lanka\",\"school\":\"University of Moratuwa\"},{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Kandy, Sri Lanka\",\"school\":\"Dharmaraja College\"},{\"details\":\"Colombo, Sri Lanka\",\"school\":\"University of Moratuwa\"},{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"}],\"facebook\":\"https://www.facebook.com/buddhikajayawar\",\"family\":[{\"name\":\"Gayantha B. Attanayake\",\"relation\":\"Cousin\"}],\"friends\":[],\"gender\":\"Male\",\"name\":\"Buddhika Jayawardhana\",\"places\":[{\"city\":\"Moratuwa, Sri Lanka\",\"status\":\"Current city\"},{\"city\":\"Matale\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15181337_1549667835047034_5854323456368472959_n.jpg?oh=a21e0c3f57c692240cf42c37dcb4e19d&oe=5903911A\",\"work\":[{\"details\":\"Founder · Colombo, Sri Lanka\",\"work\":\"Siplo\"},{\"work\":\"Omobio (Pvt) Ltd.\"}]}}},{\"government\":{\"Driving License data\":{\"Blood Type\":\"O-\",\"Date of birth\":\"11/26/1991 12:00:00 AM\",\"Full Name\":\"Kasun Buddhika Dissanayake\",\"ID\":\"913312503v\",\"Name with initials\":\"K.B.Dissanayake\",\"address\":\"256,Etaweeragollewa\",\"sex\":\"Male\"},\"NIC data\":{\"Civil Status\":\"Single\",\"Date of birth\":\"11/26/1991 12:00:00 AM\",\"District\":\"Anuradhapura\",\"E-mail\":\"kasundissanayake.12@cse.mrt.ac.lk\",\"FamilyName\":\"\",\"ID\":\"913312503v\",\"Name\":\"Kasun Buddhika\",\"Number of the house\":\"256\",\"Profession\":\"undergraduate\",\"Surname\":\"Dissanayake\",\"picture\":\"buddhika_2.jpg\",\"place of birth\":\"Anuradhapura\",\"postal code\":\"50518\",\"score\":0,\"secretariat division\":\"Madawachchiya\",\"telephone\":\"711538675\",\"village or city\":\"Etaweeragollewa\"}},\"socialMedia\":{\"facebook\":{\"_id\":{\"$oid\":\"58a09f3365f834246048be1e\"},\"birthday\":\"13 November 1992\",\"education\":[{\"details\":\"Moratuwa, Sri Lanka\",\"school\":\"University of Moratuwa - Faculty of Engineering\"},{\"details\":\"Kurunegala\",\"school\":\"Maliyadewa College\"},{\"details\":\"Kurunegala\",\"school\":\"Maliyadeva College\"}],\"facebook\":\"https://www.facebook.com/buddhika.meththasena\",\"family\":[{\"name\":\"Himashi Meththasena\",\"relation\":\"Sister\"},{\"name\":\"Lakshika Meththasena\",\"relation\":\"Brother\"}],\"friends\":[],\"gender\":\"Male\",\"languages\":[\"English\",\"Sinhala\"],\"name\":\"Buddhika Meththasena\",\"places\":[{\"city\":\"Kurunegala\",\"status\":\"Current city\"},{\"city\":\"Kurunegala\",\"status\":\"Home Town\"}],\"profile_picture\":\"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15590412_1171318699642558_6183876715588808349_n.jpg?oh=27211724e52a363e0237484c9cb9660b&oe=590CAD33\",\"work\":[{\"details\":\"Trainee Civil Engineer · Colombo, Sri Lanka\",\"work\":\"Central Engineering Consultancy Bureau\"}]},\"linkedIn\":{\"_id\":{\"$oid\":\"58a14a91fe6fb21728374761\"},\"education\":[{\"course\":\"Bachelor of science of civil engineering\",\"school\":\"University of Moratuwa\"},{\"course\":\"\",\"school\":\"Maliyadeva collage\"}],\"experience\":[{\"organisation\":\"University of Moratuwa\",\"position\":\"Student\"}],\"linkedin\":\"https://www.linkedin.com/in/buddhika-meththasena-250188a2\",\"matched\":true,\"name\":\"Buddhika Meththasena\",\"profile_picture\":\"https://media.licdn.com/mpr/mpr/shrinknp_200_200/p/6/005/07f/225/37f6662.jpg\",\"skills\":[\"Microsoft Office\",\"Microsoft Excel\"]}}}]}";
        Levenshtein l = new Levenshtein();
        NormalizedLevenshtein nl = new NormalizedLevenshtein();
        Damerau d = new Damerau();
        JaroWinkler jw = new JaroWinkler();
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        MetricLCS mlcs = new MetricLCS();
        String[] inputs= new String[20];
        int in=0;
        int length=0;
        boolean unique=true;
        //System.out.println("Type c to stop");
        String equal = "Both strings are likely to represent the same entity or one is a subset of the other";
        String notequal = "Both strings are not likely to represent the same entity and one is not a subset of the other";
        //int count=0;
        int similarityCount=0;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> output = new ArrayList<String>();
      //  Temp_UI u= new Temp_UI();
        public Aggregation(){
        list.add("a");
        list.add("in");
        list.add("at");
        list.add("of");
        }

   
public JSONObject GetJson(String d){
    
    ArrayList<List<String>> agEdu = new ArrayList<List<String>>();
    List<String> agIns = new ArrayList<String>();
    List<String> agEduDetail = new ArrayList<String>();
    
    ArrayList<List<String>> agWork = new ArrayList<List<String>>();
    List<String> agComp = new ArrayList<String>();
    List<String> agWorkDetail = new ArrayList<String>();
    JSONObject json = new JSONObject();
    
    
    
    try {
        if(d.equals("test"))    
            json = new JSONObject(buddhika);
        else
            json = new JSONObject(d);   
            //String name = (String) json.get("name");
		//System.out.println(name);
                JSONArray profileArray = json.getJSONArray("profiles");
                
// now get the first element:
                for(int i=0;i<profileArray.length();i++){
                    int eduCount=0;
                    int workCount=0;
                    int nameCount=0;
                    String nameList[]= new String[10];
                    //String addressList[] =new String[50];
                    String educationList[][]= new String[10][2];
                    String workList[][]= new String[10][2];
                    JSONObject profile;
                    JSONObject education;
                    JSONObject work;
                    profile = profileArray.getJSONObject(i);
                
// and so on    
                if(profile.has("government")){
                JSONObject government = profile.getJSONObject("government"); 
                    if(government.has("NIC data")){
                        String nicName="";
                    JSONObject nic = government.getJSONObject("NIC data");
                        if(nic.has("Family Name")&& !nic.getString("Family Name").isEmpty())
                            nicName = nic.getString("Family Name");
                         if(nic.has("Name")&& !nic.getString("Name").isEmpty())
                            nicName = nicName+" "+nic.getString("Name"); 
                         if(nic.has("Surname")&& !nic.getString("Surname").isEmpty())
                            nicName = nicName+" "+nic.getString("Surname");  
                        if(!nicName.isEmpty()){
                            nameList[nameCount] = nicName;
                            nameCount++;
                        }
                    }
                    if(government.has("Vehicle data")){
                    JSONObject vehicle = government.getJSONObject("Vehicle data");
                        if(vehicle.has("Full Name")){
                        nameList[nameCount] = vehicle.getString("Full Name");
                        nameCount++;
                        }
                    }
                    if(government.has("Driving License data")){
                    JSONObject license = government.getJSONObject("Driving License data");
                        if(license.has("Full Name")){
                        nameList[nameCount] = license.getString("Full Name");
                        nameCount++;
                        }
                    }
                }
                if(profile.has("socialMedia")){
                JSONObject socialMedia = profile.getJSONObject("socialMedia");
                    if(socialMedia.has("facebook")){
                    JSONObject facebook = socialMedia.getJSONObject("facebook");
                        if(facebook.has("name")){
                        nameList[nameCount] = facebook.getString("name");
                        nameCount++;
                        }
                        if(facebook.has("education")){
                        JSONArray educationFbArray = facebook.getJSONArray("education");
                        
                        for(int j=0;j<educationFbArray.length();j++){
                            education = educationFbArray.getJSONObject(j);
                            if(education.has("school")){
                                educationList[eduCount][0]= education.getString("school");
                            
                            if(education.has("details"))
                                educationList[eduCount][1]= education.getString("details");
                            else
                                educationList[eduCount][1]= "";
                            eduCount++;
                            
                        }
                        }
                        }
                        if(facebook.has("work")){
                        JSONArray workFbArray = facebook.getJSONArray("work");
                        
                        for(int k=0;k<workFbArray.length();k++){
                            work = workFbArray.getJSONObject(k);
                            if(work.has("work")){
                            workList[workCount][0]= work.getString("work");
                                if(work.has("details"))
                                    workList[workCount][1]= work.getString("details");
                                else
                                    workList[workCount][1]= "";
                                    
                            workCount++;
                            }
                        }
                        }
                    }
                    if(socialMedia.has("linkedIn")){
                    JSONObject linkedIn = socialMedia.getJSONObject("linkedIn");
                        if(linkedIn.has("name")){
                        nameList[nameCount] = linkedIn.getString("name");
                        nameCount++;
                        }
                        if(linkedIn.has("education")){
                        JSONArray educationLinkedInArray = linkedIn.getJSONArray("education");
                        
                        for(int j=0;j<educationLinkedInArray.length();j++){
                            education = educationLinkedInArray.getJSONObject(j);
                            if(education.has("school")){
                                educationList[eduCount][0]= education.getString("school");
                                
                                if(education.has("course"))
                                    educationList[eduCount][1]= education.getString("course");
                                else
                                    educationList[eduCount][1]= "";
                            
                                eduCount++;
                            }
                                
                        }
                        }
                        if(linkedIn.has("work")){
                        JSONArray workLinkedInArray = linkedIn.getJSONArray("work");
                        for(int k=0;k<workLinkedInArray.length();k++){
                            work = workLinkedInArray.getJSONObject(k);
                            if(work.has("work")){
                            workList[workCount][0]= work.getString("work");
                                if(work.has("details"))
                            workList[workCount][1]= work.getString("details");
                                else
                                  workList[workCount][1]= "";
                            workCount++;
                            }
                        }
                        }
                    }
                }
                
              
                
                
                
                
               
                
                
                
                 
               
                    
                
                
                
                
                
                //s.compareNames(nameList);
                //s.compareIns(educationList);
                //s.compareIns(workList);
                //profile.put("Aggregated Work", work(workList));
                profile.put("Aggregated Names", names(nameList));
                //profile.put("Aggregated Education",education(educationList));
                agEdu= education(educationList);
                agIns=agEdu.get(0);
                agEduDetail=agEdu.get(1);
                
                JSONObject jsonObj1 = new JSONObject();
                JSONArray jsonArray1 = new JSONArray();
                
                for (int j = 0; j < agIns.size(); j++)
                {
                    
                    jsonObj1 = new JSONObject();

                    jsonObj1.put("Institute",agIns.get(j));
                    jsonObj1.put("Details",agEduDetail.get(j));
                    jsonArray1.put(jsonObj1);
                }
                profile.put("Aggregated Education", jsonArray1);
                
                agWork= education(workList);
                agComp=agWork.get(0);
                agWorkDetail=agWork.get(1);
                
                JSONObject jsonObj2 = new JSONObject();
                JSONArray jsonArray2 = new JSONArray();
                
                for (int j = 0; j < agComp.size(); j++)
                {
                    
                    jsonObj2 = new JSONObject();

                    jsonObj2.put("Company",agComp.get(j));
                    jsonObj2.put("Details",agWorkDetail.get(j));
                    jsonArray2.put(jsonObj2);
                }
                profile.put("Aggregated Work", jsonArray2);
                
                
                
                //json.put(d, "aaaa");
                    
               
                
               
                }
                System.out.println(json.toString());
                
                //System.out.println(name);
                //JSONArray leaguesArray = firstSport.getJSONArray("leagues");
        } catch (JSONException ex) {
            //Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
    return json;
}
public String names(String[] in){
        int count=0;
        List<String> stringList = new ArrayList<String>(Arrays.asList(in));
         stringList.removeAll(Collections.singleton(null));
        //ArrayList<String> nameOut = new ArrayList<String>();
        String names[]= stringList.toArray(new String[stringList.size()]);
         //List<String> stringList = new ArrayList<String>(Arrays.asList(in));
         //stringList.removeAll(Collections.singleton(null));
        //stringList.add("c");
        int maxLength = 0;
            String longestString = null;
            int longestStringIndex =0;
            for (int z=0;z<names.length;z++) {
                if (names[z].length() > maxLength) {
                maxLength = names[z].length();
                longestString = names[z];
                longestStringIndex=z;
              
                }
            }
        for(int k=0;k<names.length;k++){
            if(names[k].isEmpty()){
                continue;
            }
            
      String longestStringLower=longestString.toLowerCase();
      String[] ref = longestStringLower.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
            //unique=true;
            
            String temp1= names[k];
            String temp1Lower = temp1.toLowerCase();
            if(longestStringLower.contains(temp1Lower)){
                names[k]=null;
                continue;
            }
            //if(temp1.equals("c"))
                 //   break;
            String[] token1 = temp1.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
            //Set<String> set1 = new HashSet<String>(Arrays.asList(token1));
            //set1.removeAll(list);
            //String[] array1= set1.toArray(new String[set1.size()]);
            for(int h=0;h<token1.length;h++){
                count=0;
                String st1=token1[h];
                String st1Lower=st1.toLowerCase();
                
                for(int j=0;j<ref.length;j++){
                    String st2=ref[j];
                    double jwinkler=jw.similarity(st1Lower, st2);
                    double nlevenstein=nl.distance(st1Lower, st2);
                if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    count++;
                    similarityCount++;
                }
                
                    
                
                }
                if(count==0){
                longestString = st1+" "+longestString;
                
                }
            
            
            }
            
            
  
        }
        
        System.out.println(longestString);
        return longestString;
    }
public ArrayList<String> names1(String[] in){
        int count=0;
        ArrayList<String> nameOut = new ArrayList<String>();
         List<String> stringList = new ArrayList<String>(Arrays.asList(in));
         stringList.removeAll(Collections.singleton(null));
        stringList.add("c");
        for(int k=0;!stringList.get(k).equals("c");){
            unique=true;
            String temp1= stringList.get(k);
            //if(temp1.equals("c"))
                 //   break;
            String[] token1 = temp1.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
            Set<String> set1 = new HashSet<String>(Arrays.asList(token1));
            set1.removeAll(list);
            String[] array1= set1.toArray(new String[set1.size()]);
            
            for(int m=k+1;!stringList.get(m).equals("c");){
                
                String temp2= stringList.get(m);
               // if(temp2.equals("c"))
                    //break;
                String[] token2 = temp2.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
                Set<String> set2 = new HashSet<String>(Arrays.asList(token2));
                set2.removeAll(list);
                
                String[] array2= set2.toArray(new String[set2.size()]);
        
        String result= null;
        
            for(int i=0;i<token1.length;i++){
                //System.out.println(token2[i]);
                for(int j=0;j<token2.length;j++){
                    
                    String st1=token1[i].toLowerCase();
                    String st2=token2[j].toLowerCase();
                    //if(i==j){
                        //if(st1.equals(st2)){
                          //  similarityCount++;
                        //}//else
                          //  similarityCount=0;
                        
                   // }
                    double jwinkler=jw.similarity(st1, st2);
                    double nlevenstein=nl.distance(st1, st2);
                if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    count++;
                    similarityCount++;
                }
            }
                
            }
            
            //System.out.println(count);
             if(count==token2.length){
            result=temp1;
            stringList.set(m, result);
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }else if(count==token1.length){
            result=temp2;
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }
            //else{
            //result=notequal+"- "+temp1+" and "+temp2;
            //m++;
            //}
            
            else if(similarityCount>0){
              if(token1.length>token2.length)
                result= temp1;
              else
                  result=temp2;
              String temp3=temp1+","+temp2;
              String[] token3 = temp3.split("[\\s,]+", -1);
              Set<String> set3 = new HashSet<String>(Arrays.asList(token3));
                set3.removeAll(list);
                
                String[] array3= set3.toArray(new String[set3.size()]);
              for(int i=0;i<array3.length;i++){
               if(result.contains(array3[i])) {
                  } else { 
                      result+= " "+array3[i];
                  } 
              
                   }

               stringList.set(m, result);
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
               
            }
           else{
            result=notequal+"- "+temp1+" and "+temp2;
            m++;
            }
        //System.out.println(result);
            }
            if(unique==true){
                System.out.println(stringList.get(k));
                
                output.add(stringList.get(k));
                nameOut.add(stringList.get(k));
                
            }
            stringList.remove(k);
        }
        
        for(int r=0;r<stringList.size();r++){
            String res=stringList.get(r);
            if(!res.equals("c"))
                System.out.println(res);
        
        }
        return nameOut;
    }
    public ArrayList<List<String>> education(String[][] in){
        int count=0;
        ArrayList<List<String>> eduOut = new ArrayList<List<String>>();
        ArrayList<String> insOut = new ArrayList<String>();
        ArrayList<String> detailOut = new ArrayList<String>();
        
        List<String> stringList = new ArrayList<String>();
        List<String> detailList = new ArrayList<String>();
        for (int i = 0; i < in.length; i++) {
        // tiny change 1: proper dimensions
            stringList.add(in[i][0]);
          //if(!in[i][0].equals(null))
            detailList.add(in[i][1]); 
            
        }
        //ArrayList<String> stringList = new ArrayList<String>();
        //ArrayList<String> stringList = (ArrayList<String>) Arrays.asList(in);
        //List<String> stringList = new ArrayList<String>(Arrays.asList(in));
        stringList.removeAll(Collections.singleton(null));
        detailList.removeAll(Collections.singleton(null));
        stringList.add("c");
        for(int k=0;!stringList.get(k).equals("c");){
            unique=true;
            String temp1= stringList.get(k);
            //temp1="A-B.C,D E . F , G   -H I";
            //if(temp1.equals("c"))
                 //   break;
            String[] token1 = temp1.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
            Set<String> set1 = new HashSet<String>(Arrays.asList(token1));
            set1.removeAll(list);
            String[] array1= set1.toArray(new String[set1.size()]);
            
            for(int m=k+1;!stringList.get(m).equals("c");){
                
                String temp2= stringList.get(m);
               // if(temp2.equals("c"))
                    //break;
                String[] token2 = temp2.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
                Set<String> set2 = new HashSet<String>(Arrays.asList(token2));
                set2.removeAll(list);
                
                String[] array2= set2.toArray(new String[set2.size()]);
        
        String result= null;
        
            for(int i=0;i<array1.length;i++){
                //System.out.println(token2[i]);
                for(int j=0;j<array2.length;j++){
                    
                    String st1=array1[i].toLowerCase();
                    String st2=array2[j].toLowerCase();
                    //if(i==j){
                        //if(st1.equals(st2)){
                          //  similarityCount++;
                        //}//else
                          //  similarityCount=0;
                        
                   // }
                    double jwinkler=jw.similarity(st1, st2);
                    double nlevenstein=nl.distance(st1, st2);
//                    String st3= "University of Moratuwa, Katubedda";
//                    String st4= "Moratuwa University, Sri Lanka";
//                    double jwinkler1=jw.similarity(st3, st4);
//                    double nlevenstein1=nl.distance(st3, st4);
//                    System.out.println(jwinkler1+" "+nlevenstein1);
                if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    count++;
                    similarityCount++;
                }
            }
                
            }
            
            //System.out.println(count);
             if(count==array2.length){
            result=temp1;
            
            stringList.set(m, result);
            detailList.set(m, details(detailList.get(k), detailList.get(m)));
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }else if(count==array1.length){
            result=temp2;
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }
            else if(count>Math.min(token1.length, token2.length)/2){
              if(token1.length>token2.length)
                result= temp1;
              else
                  result=temp2;
              String temp3=temp1+","+temp2;
              String[] token3 = temp3.split("[\\s,]+", -1);
              Set<String> set3 = new HashSet<String>(Arrays.asList(token3));
                set3.removeAll(list);
                if(set3.contains("Sri") && set3.contains("Lanka")){
                    set3.remove("Sri");
                    set3.remove("Lanka");
                    set3.add("Sri Lanka");
                
               }
                String[] array3= set3.toArray(new String[set3.size()]);
              for(int i=0;i<array3.length;i++){
               if(result.contains(array3[i])) {
                  } else { 
                      result+= " "+array3[i];
                  } 
              
                   }

               stringList.set(m, result);
               detailList.set(m, details(detailList.get(k), detailList.get(m)));
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
               
            }
            else{
            result=notequal+"- "+temp1+" and "+temp2;
            m++;
            }
        
        //System.out.println(result);
            }
            if(unique==true){
                System.out.println(stringList.get(k));
                System.out.println(detailList.get(k));
                output.add(stringList.get(k));
                insOut.add(stringList.get(k));
                detailOut.add(detailList.get(k));
            }
            stringList.remove(k);
            detailList.remove(k);
        }
        
        for(int r=0;r<stringList.size();r++){
            String res=stringList.get(r);
            if(!res.equals("c"))
                System.out.println(res);
        
        }
        /*for(int r=0;r<detailList.size();r++){
            String res=detailList.get(r);
            
                System.out.println(res);
        
        }*/
        eduOut.add(0, insOut);
        eduOut.add(1, detailOut);
        return eduOut;
    }
    public ArrayList<List<String>> work(String[][] in){
        int count=0;
        ArrayList<List<String>> workOut = new ArrayList<List<String>>();
        ArrayList<String> insOut = new ArrayList<String>();
        ArrayList<String> detailOut = new ArrayList<String>();
        //ArrayList<String> stringList = new ArrayList<String>();
        //ArrayList<String> stringList = (ArrayList<String>) Arrays.asList(in);
        List<String> stringList = new ArrayList<String>();
        List<String> detailList = new ArrayList<String>();
        for (int i = 0; i < in.length; i++) {
        // tiny change 1: proper dimensions
            stringList.add(in[i][0]);
          //if(!in[i][0].equals(null))
            detailList.add(in[i][1]); 
            
        }
        //ArrayList<String> stringList = new ArrayList<String>();
        //ArrayList<String> stringList = (ArrayList<String>) Arrays.asList(in);
        //List<String> stringList = new ArrayList<String>(Arrays.asList(in));
        stringList.removeAll(Collections.singleton(null));
        detailList.removeAll(Collections.singleton(null));
        stringList.add("c");
        for(int k=0;!stringList.get(k).equals("c");){
            unique=true;
            String temp1= stringList.get(k);
            //if(temp1.equals("c"))
                 //   break;
            String[] token1 = temp1.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
            Set<String> set1 = new HashSet<String>(Arrays.asList(token1));
            set1.removeAll(list);
            String[] array1= set1.toArray(new String[set1.size()]);
            
            for(int m=k+1;!stringList.get(m).equals("c");){
                
                String temp2= stringList.get(m);
               // if(temp2.equals("c"))
                    //break;
                String[] token2 = temp2.split("[\\s,|\\s.|\\s-|\\.|,|-]+", -1);
                Set<String> set2 = new HashSet<String>(Arrays.asList(token2));
                set2.removeAll(list);
                
                String[] array2= set2.toArray(new String[set2.size()]);
        
        String result= null;
        
            for(int i=0;i<array1.length;i++){
                //System.out.println(token2[i]);
                for(int j=0;j<array2.length;j++){
                    
                    String st1=array1[i].toLowerCase();
                    String st2=array2[j].toLowerCase();
                    //if(i==j){
                        //if(st1.equals(st2)){
                          //  similarityCount++;
                        //}//else
                          //  similarityCount=0;
                        
                   // }
                    double jwinkler=jw.similarity(st1, st2);
                    double nlevenstein=nl.distance(st1, st2);
//                    String st3= "University of Moratuwa, Katubedda";
//                    String st4= "Moratuwa University, Sri Lanka";
//                    double jwinkler1=jw.similarity(st3, st4);
//                    double nlevenstein1=nl.distance(st3, st4);
//                    System.out.println(jwinkler1+" "+nlevenstein1);
                if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    count++;
                    similarityCount++;
                }
            }
                
            }
            
            //System.out.println(count);
             if(count==array2.length){
            result=temp1;
            stringList.set(m, result);
            detailList.set(m, details(detailList.get(k), detailList.get(m)));
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }else if(count==array1.length){
            result=temp2;
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }
            else if(count>Math.min(token1.length, token2.length)/2){
              if(token1.length>token2.length)
                result= temp1;
              else
                  result=temp2;
              String temp3=temp1+","+temp2;
              String[] token3 = temp3.split("[\\s,]+", -1);
              Set<String> set3 = new HashSet<String>(Arrays.asList(token3));
                set3.removeAll(list);
                if(set3.contains("Sri") && set3.contains("Lanka")){
                    set3.remove("Sri");
                    set3.remove("Lanka");
                    set3.add("Sri Lanka");
                
               }
                String[] array3= set3.toArray(new String[set3.size()]);
              for(int i=0;i<array3.length;i++){
               if(result.contains(array3[i])) {
                  } else { 
                      result+= " "+array3[i];
                  } 
              
                   }

               stringList.set(m, result);
               detailList.set(m, details(detailList.get(k), detailList.get(m)));
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
               
            }
            else{
            //result=notequal+"- "+temp1+" and "+temp2;
            m++;
            }
        
        //System.out.println(result);
            }
            if(unique==true){
                System.out.println(stringList.get(k));
                System.out.println(detailList.get(k));
                output.add(stringList.get(k));
                insOut.add(stringList.get(k));
                detailOut.add(detailList.get(k));
            }
            stringList.remove(k);
            detailList.remove(k);
        }
        
        /*for(int r=0;r<stringList.size();r++){
            String res=stringList.get(r);
            if(!res.equals("c"))
                System.out.println(res);
        
        }*/
        workOut.add(0, insOut);
        workOut.add(1, detailOut);
        return workOut;
    }
    public ArrayList<String> addresses(String[] in){
        ArrayList<String> addressOut = new ArrayList<String>();
        int count=0;
         List<String> stringList = new ArrayList<String>(Arrays.asList(in));
         stringList.removeAll(Collections.singleton(null));
        stringList.add("c");
        for(int k=0;!stringList.get(k).equals("c");){
            unique=true;
            String temp1= stringList.get(k);
            //if(temp1.equals("c"))
                 //   break;
            String[] token1 = temp1.split("\\s*,\\s*", -1);
            Set<String> set1 = new HashSet<String>(Arrays.asList(token1));
            set1.removeAll(list);
            String[] array1= set1.toArray(new String[set1.size()]);
            
            for(int m=k+1;!stringList.get(m).equals("c");){
                
                String temp2= stringList.get(m);
               // if(temp2.equals("c"))
                    //break;
                String[] token2 = temp2.split("\\s*,\\s*", -1);
                Set<String> set2 = new HashSet<String>(Arrays.asList(token2));
                set2.removeAll(list);
                
                String[] array2= set2.toArray(new String[set2.size()]);
        
        String result= null;
        
            for(int i=0;i<token1.length;i++){
                //System.out.println(token2[i]);
                for(int j=0;j<token2.length;j++){
                    
                    String st1=token1[i].toLowerCase();
                    String st2=token2[j].toLowerCase();
                    //if(i==j){
                        //if(st1.equals(st2)){
                          //  similarityCount++;
                        //}//else
                          //  similarityCount=0;
                        
                   // }
                    double jwinkler=jw.similarity(st1, st2);
                    double nlevenstein=nl.distance(st1, st2);
                if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    similarityCount++;
                    count++;
                    
                }
            }
                
            }
            
            //System.out.println(count);
            if(count==token2.length){
            result=temp1;
            stringList.set(m, result);
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }else if(count==token1.length){
            result=temp2;
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
            }
            else if(similarityCount>=Math.min(token1.length, token2.length)/2){
              if(token1.length>token2.length)
                result= temp1;
              else
                  result=temp2;
              String temp3=temp1+","+temp2;
              String[] token3 = temp3.split("[\\s,]+", -1);
              Set<String> set3 = new HashSet<String>(Arrays.asList(token3));
                set3.removeAll(list);
                if(set3.contains("Sri") && set3.contains("Lanka")){
                    set3.remove("Sri");
                    set3.remove("Lanka");
                    set3.add("Sri Lanka");
                
               }
                String[] array3= set3.toArray(new String[set3.size()]);
              for(int i=0;i<array3.length;i++){
               if(result.contains(array3[i])) {
                  } else { 
                      result+= " "+array3[i];
                  } 
              
                   }

               stringList.set(m, result);
            //stringList.remove(k);
            unique=false;
            count=0;
            similarityCount=0;
            break;
               
            }
            else{
            result=notequal+"- "+temp1+" and "+temp2;
            m++;
            }
        
        //System.out.println(result);
            }
            if(unique==true){
                System.out.println(stringList.get(k));
                output.add(stringList.get(k));
                addressOut.add(stringList.get(k));
            }
            stringList.remove(k);
        }
        
        for(int r=0;r<stringList.size();r++){
            String res=stringList.get(r);
            if(!res.equals("c"))
                System.out.println(res);
        
        }
        return addressOut;
    }
    
    public String details(String st1,String st2){
        /*if(st1==null)
            return st2;
        if(st2==null)
            return st1;*/
        String str1= st1.toLowerCase();
        String str2= st2.toLowerCase();
        
        
        if(str1.contains(str2))
            return str1;
        else if(str2.contains(str1))
            return str2;
        else {
            String[] token1 = str1.split("[\\.|,|-|·]+", -1);
            //Set<String> set1 = new HashSet<String>(Arrays.asList(token1));
            //set1.removeAll(list);
            //String[] array1= set1.toArray(new String[set1.size()]);
            List<String> list1 = new ArrayList<String>(Arrays.asList(token1));
            String[] token2 = str2.split("[\\.|,|-|·]+", -1);
            //Set<String> set2 = new HashSet<String>(Arrays.asList(token2));
            //set2.removeAll(list);
            //String[] array2= set2.toArray(new String[set2.size()]);
            List<String> list2 = new ArrayList<String>(Arrays.asList(token2));
            if(list1.size()>=list2.size()){
                
                for(int i=0;i<list1.size();i++){
                //System.out.println(token2[i]);
                
                for(int j=0;j<list2.size();j++){
                    String temp1= list1.get(i);
                    String temp2= list2.get(j);
                    /*double jwinkler=jw.similarity(st1, st2);
                    double nlevenstein=nl.distance(st1, st2);

                    if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    count++;
                    
                    }*/
                    if(temp2.contains(temp1)){
                        list1.set(i, temp2);
                        list2.remove(j);
                    }else if(temp1.contains(temp2)){
                        list2.remove(j);
                    }
                }
                
                }
                if(!list2.isEmpty()){
                    for(int k=0;k<list2.size();k++){
                        list1.add(list2.get(k));
                    }
                        
                }
                StringBuilder sb = new StringBuilder();
                for (String s : list1)
                {
                sb.append(s);
                sb.append(", ");
                }
                return sb.toString();
            }
            else{
                
                for(int i=0;i<list2.size();i++){
                //System.out.println(token2[i]);
                
                for(int j=0;j<list1.size();j++){
                    String temp1= list2.get(i);
                    String temp2= list1.get(j);
                    /*double jwinkler=jw.similarity(st1, st2);
                    double nlevenstein=nl.distance(st1, st2);

                    if(st1.equals(st2)||jwinkler>0.9500 && nlevenstein<0.2000){
                    count++;
                    
                    }*/
                    if(temp2.contains(temp1)){
                        list2.set(i, temp2);
                        list1.remove(j);
                    }else if(temp1.contains(temp2)){
                        list1.remove(j);
                    }
                }
                
            }
                if(!list1.isEmpty()){
                    for(int k=0;k<list1.size();k++){
                        list2.add(list1.get(k));
                    }
                        
                }
                StringBuilder sb = new StringBuilder();
                for (String s : list2)
                {
                sb.append(s);
                sb.append(", ");
                }
                return sb.toString();
            }
                
           
        }
        
    }
   
    
}
