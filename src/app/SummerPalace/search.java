package app.SummerPalace;
//使用Sql数据库时要用
//import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

//用于调试
//import android.util.Log;

//import android.view.View.*;
//import android.os.Bundle;
//import android.app.Activity;
//import android.content.*;
//import android.app.AlertDialog;
//import android.content.res.Resources;
//import android.graphics.drawable.Drawable;
//import android.app.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.*;
import android.widget.*;
import android.app.Dialog;
import java.util.ArrayList;
import com.iflytek.speech.RecognizerResult;
import com.iflytek.speech.SpeechError;
import com.iflytek.ui.RecognizerDialog;
import com.iflytek.ui.RecognizerDialogListener;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class search extends Activity {

	EditText editText = null;
	ImageButton startButton = null;
	Button search=null;
	Button search1=null;
	
	TextView[] view=new TextView[10];
	
	TextView intro1 = null;
	TextView intro2 = null;
	TextView intro3 = null;
    ImageView picture = null;
    TextView shipin = null;
	
	public TextView j=null;
	int i;
	
	String message=null;
	
	View source;
	
	String s="";
	String s1="";
    String s2="";
    String s3="";
    String s4="";
    String s0="";
    SQLiteDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
      
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		setTitle("  颐和园景区导航");
		
		editText = (EditText) findViewById(R.id.TextResult);
		startButton = (ImageButton) findViewById(R.id.imageButton1);
		search=(Button) findViewById(R.id.Search);
		search1=(Button) findViewById(R.id.Search1);
		
		j=(TextView) findViewById(R.id.where1);
		
		view[0]=j;
		view[1]=(TextView) findViewById(R.id.where2);
		view[2]=(TextView) findViewById(R.id.where3);
		view[3]=(TextView) findViewById(R.id.where4);
		view[4]=(TextView) findViewById(R.id.where5);
		view[5]=(TextView) findViewById(R.id.where6);
		view[6]=(TextView) findViewById(R.id.where7);
		view[7]=(TextView) findViewById(R.id.where8);
		view[8]=(TextView) findViewById(R.id.where9);
		view[9]=(TextView) findViewById(R.id.where10);

		try{
			db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/景区.db3", null);
		}
		catch(SQLiteException se)
		{
			message="数据库创建失败！！！";
			ShowDialog(source);
		}
		Cursor cursor;
		try
		{
			cursor = db.rawQuery("select * from 景点信息   where name=?"
					, new String[] {"黄鹤楼"});
		}
		catch (SQLiteException se)
		{
			String sql = "create table 景点信息(ID varchar(255) primary key, name varchar(255), 介绍1 varchar(255), 介绍2 varchar(255), 介绍3 varchar(255), 视频 varchar(255), 特征1 varchar(255), 特征2 varchar(255), 特征3 varchar(255))";
			db.execSQL(sql);
			db.execSQL("insert into 景点信息 values('1' , '仁寿殿' , '仁寿殿，清漪园时名勤政殿，始建于清乾隆十五年（1750），咸丰十年（1860）被英法联军烧毁，光绪十二年（1886）重建，取《论语》中“仁者寿”之意，改名仁寿殿。这里是慈禧和光绪住园期间临朝理政，接受恭贺和接见外国使节的地方，是颐和园听政区的主要建筑。', '仁寿殿位于颐和园东宫门内，是宫廷区的主要建筑之一，乾隆清漪园时期称“勤政殿”，建于1750年，意为不忘勤理政务；光绪年间改为今名，意为施仁政者长寿。仁寿殿坐西向东，面阔七间，两侧有南北配殿，前有仁寿门，门外有南北九卿房。', '仁寿殿是慈禧太后和光绪皇帝在颐和园居住时朝会大臣、接见外国使节的地方，为园内最主要的政治活动场所，也是中国近代史上变法维新运动的策划地之一。1898年光绪皇帝曾在此殿召见改良派领袖康有为，任命他为总理各国事务衙门章京上行走，准其专摺奏事，从而揭开了维新变法的序幕。但好景不长，由于封建保守势力的反对，“百日维新”终归失败。', 'http://www.56.com/u54/v_NTEwNDAyMTk.htm', '勤政', '瑞兽', '朝政')");
			db.execSQL("insert into 景点信息 values('2' , '玉澜堂' , '玉澜堂是一座三合院式的建筑，正殿玉澜堂坐北朝南，东配殿霞芬室，西配殿藕香榭。三个殿堂原先均有后门，东殿可到仁寿殿，西殿可到湖畔码头，正殿后门直对宜芸馆。', '玉澜堂内有地平床，设宝座、御案、香几、围屏等，它们都是用紫檀木和沉香木镶嵌、拼贴、雕造而成，高雅端庄，制作精美，两端的玻璃立屏，又衬托出简洁高雅、古朴清爽的审美情趣。东暖阁为光绪的早餐室，西暖阁为寝室。近代史上许多著名的人物，如翁同和、康有为等，都曾留下历史的痕迹。','”戊戌变法“失败后，光绪被软禁在南海的瀛台岛上。每年慈禧来颐和园时，光绪帝也必须跟随同来，住在玉澜堂。为了严密控制光绪帝，慈禧命人在玉澜堂前后左右修砌了多道砖墙，门口还有太监站岗。此时的玉澜堂被全面封闭起来，活像一座监狱，光绪在这里完全失去了行动自由。近百年来，原为囚禁光绪帝用的砖墙已拆去不少，玉澜堂也基本上恢复了皇帝寝宫的面貌，只有玉澜堂东西配殿内的暗墙仍然保持原样，作为与戊戌变法有关的遗迹和历史见证，供人参观。','http://www.tudou.com/programs/view/wq_mn6XUgkc/','囚禁',null,null)");
			db.execSQL("insert into 景点信息 values('3' , '佛香阁' , '佛香阁是一座宏伟的塔式宗教建筑，为全园建筑布局的中心。“佛香”二字来源于佛教对佛的歌颂。清乾隆时（1736-1795）在此筑九层延寿塔，至第八层“奉旨停修”，改建佛香阁。咸丰十年（1860年）毁于英法联军，光绪时（1875一1908）在原址依样重建，供奉佛像。','该阁仿杭州的六和塔建造，兴建在20米的石造台基上，八面三层四重檐。阁高41米，八面，三层，四重檐。阁内有八根铁梨木大柱，直贯顶部，下有20米高的石台基。阁上层榜曰 “式延风教”，中层榜曰“气象昭回”，下层榜曰“云外天香”，阁名 “佛香阁”。内供接引佛，每月望朔，慈禧在此烧香礼佛。 游人至此，居高临下，可以饱览昆明湖及几十里以外的明媚风光。','颐和园是清王朝修建的一座规模宏大的皇家园林。因此，人们对这座皇家园林中的中心建筑物佛香阁的修建，就特别的慎重，也特别的用心。据说，修建佛香阁的木料，有的来自西南，有的来自东北。修建佛香阁的石料，有的来自江苏太湖，有的来自云南大理。修建佛香阁的工匠，有的来自西安，有的来自苏州。可见佛香阁的修建同颐和园一样，是全国劳动人民智慧和血汗的结晶 。','http://v.ku6.com/show/jwkJk_4DRWjcL418TR4-pg...html','宗教','供佛',null )");
			db.execSQL("insert into 景点信息 values('4' , '排云殿' , '排云殿原始乾隆为其母后60寿辰而建的大报恩延寿寺，慈禧重建的时候更名为排云殿，排云殿在万寿山前建筑的中心部位，“排云”二字取自郭璞诗：“神仙排云山，单肩金银台”。这组建筑是颐和园最为壮观的建筑群。','排云殿地处万寿山前建筑的中心部位，是慈禧过生日时接受朝拜的地方，它建在一座高台上，歇山重檐，前后由21间房屋组成。殿内有宝座、围屏、鼎炉、宫扇等，平台下对称排列着供防火盛水用的四口大铜缸，俗称“门海”。 排云殿四周有游廊和配殿，前院有水池或汉白玉砌成的金水桥。殿角重重叠叠，琉璃五彩缤纷。从远处望去，排云殿与牌楼、排云门、金水桥、二宫门连成了层层升高的一条直线。排云殿这组建筑，是颐和园最为壮观的建筑群体。“排云”二字出自晋朝郭璞“神仙排云出，但见金银台”的诗句，这比喻似在云雾缭绕的仙山琼阁中，神仙即将露面。','在乾隆时期，这组建筑叫“大报恩延寿寺”，1860年被英法联军焚毁，光绪年间重建，并改名“排云殿”。据说，开始时慈禧想把这里作为她的寝宫，但在刚落成时慈禧就得了一场病，她认为到可能是此殿距佛门侧境“佛香阁”太近，不适于长期居住，后来她才决定把寝宫改在乐寿堂，而排云殿只作为她过生日时接受朝拜的地方。','http://v.youku.com/v_show/id_XNDU4MjEzMjU2.html','玉华','云锦','生日')");
			db.execSQL("insert into 景点信息 values('5' , '长廊' , '位于万寿山南麓，面向昆明湖，被依万寿山，东起邀月门，西止石丈停。全长728米，1992年被世界吉尼斯纪录认定为世界最长的长廊。','廊上的每根枋梁上都有彩绘，共有图画14000余幅，内容包括山水风景、花鸟鱼虫、人物典故等。画中的人物画均取材于中国古典名著。','长廊始建于乾隆十五年颐和园长廊（1750），后被英法联军烧毁，光绪十二年（1886）重建。长廊东起邀月门，西至石丈亭，共二百七十三间，全长七百二十八米，枋梁上还绘有人物、山水、花鸟等各种彩画八千多幅，是中国古典园林中最长的游廊。长廊中间建有留佳、寄澜、秋水、清遥四座八角重檐的亭子，依山临水，以排云殿为中心，向东西两边对称地展开，将分布在万寿山前的建筑连成一气。','http://v.youku.com/v_show/id_XMjg1MzcxNg==.html','彩绘','邀月','石丈')");
			db.execSQL("insert into 景点信息 values('6' , '清晏舫' , '清晏舫原称石肪。在颐和园万寿山西麓昆明湖岸边、是园中著名的水上建筑。','该舫建于乾隆十二年（1755），舫体由大理石雕成，上面原为中式楼阁。1860年英法联军将舫上楼阁烧毁。1893年重建时，仿翔凤火轮式样，改为西洋式楼阁并配以彩色玻璃窗船侧加了两个机轮，名清晏舫，两层船舫各有大镜，细雨蒙蒙之时，慈禧坐在镜前，一面品茗，一面欣赏镜中雨景。','石舫在长廊西端湖边，是一条大石船，取名清晏舫，寓“海清河晏”之意。是颐和园唯一带有西洋风格的建筑。石舫长36米，船身上建有两层船楼，船底花砖铺地，窗户为彩色玻璃，顶部砖雕装饰。下雨时，落在船顶的雨水通过四角的空心柱子，由船身的四个龙头口排入湖中，设计十分巧妙。','http://v.youku.com/v_show/id_XNDEyNTAyNDA4.html','石舫','西洋','翔凤')");
			db.execSQL("insert into 景点信息 values('7' , '十七孔桥' , '十七孔桥是颐和园中著名的景点之一。它东连廓如亭，西接南湖岛，长150米，堪称中国园林中最大的桥梁。清乾隆时（1736一1795）建。','十七孔桥是一座联拱石桥。桥面下宽14.6米，桥面上宽6.56米，高7米。整座桥给人以一种雄伟高大之感。这座桥共有17个桥洞，所以叫十七孔桥。在这17个桥孔中，第9孔最大，由中间向两端逐渐小下来，对称排列。水面未冻结时，桥洞与水中的倒影成纺锤形，十分美丽。由于桥孔大小不一，所以桥面有一定的坡度，像一张弓。十七孔桥象天空中七彩的长虹飞架在碧波万顷的昆明湖上，又像神话中的鼍龙状如半月浮游在平滑似镜的水中。','此桥的风景，在优雅宁静之夜游赏更加怡人。十七孔桥上石雕极其精美，每个桥栏的望柱上都雕有神态各异的狮子，大小共五百四十四只。桥两边的白石栏杆，共有128根望柱，每根望柱上都雕刻着精美的姿态各异的石狮，有的母子相抱，有的玩耍嬉闹，有的你追我赶，有的凝神观景，个个惟妙惟肖。桥头各有两只大水兽，很像麒麟，十分威武。桥的两头有四只石刻异兽，形象威猛异常，极为生动。','http://v.youku.com/v_show/id_XNDEyNTAwNDU2.html','十七','石桥','石雕')");
			db.execSQL("insert into 景点信息 values('8' , '文昌阁' , '东堤上，连接知春亭的知春桥头，矗立着一座高大巍峨的城关式建筑，这就是文昌阁，文昌阁得名于文运昌盛，“文昌”即文昌帝君，文昌帝君是道教中主掌功名利禄之神，受到古代文人的特别尊崇。清代中状元者有幸到颐和园一游时，必定要到文昌阁来拜谒文昌帝君。在清漪园的造园设计中，在万寿山西麓宿云檐供奉关帝，在这里供奉文昌帝君有文武辅政之寓意。','文昌阁始建于1750年，是园内六座城关（宿云檐、文昌阁、千峰彩翠、寅辉、紫气东来、通云）中最大的一座。乾隆时期，昆明湖东、西、南三面并没有围墙，这座城关即成为从东南方向入园的门户。','文昌阁是建在城关基座上的楼阁式建筑，城头四隅角廊平面呈“人”字形，中间为三层楼阁。1860年遭英法联军破坏，直至慈禧重修颐和园时才将其改建。改建后为上下两层，顶部为十字形黄琉璃绿剪边琉璃屋面。文昌阁中供奉着文昌帝君铜像，两小侍童伴其左右，旁边一匹铜骡，体态自然，传说是帝君的乘骑。站在文昌阁上，既可以远眺万寿山和西山风景，亦可俯瞰昆明湖全貌，应该是个观景的好地方。','http://v.youku.com/v_show/id_XNTY1OTYxNDcy.html','城关','楼阁','帝君')");
			db.execSQL("insert into 景点信息 values('9' , '谐趣园' , '谐趣园在万寿山东麓，是一个独立成区、具有南方园林风格的园中之园。清漪园时名叫惠山园”，是仿无锡惠山寄畅园而建。嘉庆十六年（1811年）重修后，取“以物外之静趣，谐寸田之中和”和乾隆皇帝的诗句“一亭一径，足谐奇趣”的意思，改名为“谐趣园”。园内共有亭、台、堂、榭十三处，并用百间游廊和五座形式不同的桥相沟通。','入谐趣园，只见一池荷花，亭亭玉立，园内有一丛绿竹，竹荫深处，有山泉分成数股注入荷池。这道山泉的水源，来自昆明湖后湖东端，谐趣园取如此低洼的地势，主要就是为了形成这道山泉，使谐趣园的水面与后湖的水面形成一二米的落差，而在一二米的落差中，又运用山石的堆叠，分成几个层次，使川流不息的水声高低扬抑，犹如琴韵，难怪横卧在泉边的一块巨石上，镌有“玉琴峡”三字。有此一景，使这座园中之园有声有色，可谓谐趣园的“声趣”。','在玉琴峡西侧有一座瞩新楼，这座楼从园内侧看是两层楼，若从外层看，却是一层。原来，谐趣园宫门前是那条下坡路的最低点，继续往前，又逐步升高，可以直接步入瞩新楼的上层，这种似楼非楼的设计，可谓“楼趣”。谐趣园中共有桥五座，其中以知鱼桥最为著名。接近水面，便于观鱼，取名知鱼桥，是引用了战国时代庄子和惠子在“秋水濠上”的一次有关知鱼不知乐的富有哲理的辩论游戏。用古人的故事来增添游人的兴味，这是园中的“桥趣”。','http://v.youku.com/v_show/id_XNTY3MzA1ODgw.html','声趣','楼趣','桥趣')");
			db.execSQL("insert into 景点信息 values('10' , '苏州街' , '苏州街又称“买卖街”。苏州街是后湖两岸仿江南水乡——苏州而建的买卖街。清漪园时期岸上有各式店铺，如玉器古玩店、绸缎店、点心铺、茶楼、金银首饰楼等。店铺中的店员都是太监、宫女妆扮。皇帝游幸时开始“营业”。后湖岸边的数十处店铺1860年被列强焚毁。现在的景观为1986年重修','苏州街既是一处历史人文景观，又是一处独特的自然景观，列于宫苑之中，小巧玲珑，依山面水，宛如江南图画点缀在后山后湖的建筑轴线上，更加衬托了后湖的宁静典雅，把城市山林集中形象地再现出来，成了乾隆皇帝的母亲最喜欢游玩之处。','苏州街无论水中还是水边的建筑，皆与万寿山上景观呼应，整体布局，造景有序。而复原工作以实物为依据，不增不减，不移不挪，不放大不缩小，真实再现从历史上和后湖空间中丢失了一个多世纪的这组建筑群。','http://v.youku.com/v_show/id_XMzE1NjM5NzMy.html','后湖','江南','店铺')");
		}
		
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(1);
			}
		});
		
	//为相关列表景区的TextView控件添加点击处理（不知为何不能直接用for循环，会出各种错）
	for(i=0;i<10;i++)
	{
		view[i].setOnClickListener(on);
	}
	
	search.setOnClickListener(new OnClickListener() {
	@Override
	public void onClick(View v) {
      for(i=0;i<10;i++)
      {
          view[i].setTextColor(0xff000000);
      }
		if(editText.getText().toString().isEmpty())
		{
			message="请输入搜索景点！！！";
			ShowDialog(source);
			return;
		}
		else //搜索框内为非空
		{ 
			s=editText.getText().toString();  //s为要搜索景点的名称
			
			//按名称(s)搜索
			//相关代码
			Cursor cursor;
			cursor = db.rawQuery("select * from 景点信息   where name=?"
					, new String[] {s});
			if(cursor.getCount()==0)
			{
				s0="";
			}
			else
			{
				cursor.moveToFirst();
				s0=cursor.getString(0);
				s=cursor.getString(1);
				s1=cursor.getString(2);
				s2=cursor.getString(3);
				s3=cursor.getString(4);
				s4=cursor.getString(5);
			}
			
			if(s0.isEmpty())
			{
		        message="对不起，未找到相关景点！";
		        ShowDialog(source);
		        s=null;
		        return;
			}
			//否则更新s,s0,s1,s2,s3,s4(s0为“ID”——用于显示图片，s1/s2/s3为介绍1、2、3,s4为视频对应的链接)
			
		   for(i=0;i<10;i++)  //判断输入的景区是否为列表中的景区
		       {
		            if(s.equals(view[i].getText().toString()))
		            {
		                view[i].setTextColor(0xffccff33);
		                j=view[i];
		                Intent intent=new Intent();
		                intent.putExtra("name", s);   //传递搜索景区的名称
		                intent.putExtra("intro1", s1);  //传递搜索景区的介绍1
		                intent.putExtra("intro2", s2);  //传递搜索景区的介绍2
		                intent.putExtra("intro3", s3);  //传递搜索景区的介绍3
		                intent.putExtra("shipin", s4);  //传递搜索景区的视频链接
		                intent.putExtra("ID", s0);   //传递搜索景区的ID
		                intent.setClass(search.this, Introduce.class);
		                startActivity(intent);
		            }
		       }
		}
		}
	});
	
	search1.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
	        for(i=0;i<10;i++)
	        {
	            view[i].setTextColor(0xff000000);
	        }
			if(editText.getText().toString().isEmpty())
			{
				message="请输入搜索景点的特征！！！";
				ShowDialog(source);
				return;
			}
			else //搜索框内为非空
			{ 
				s=editText.getText().toString();  //s为要搜索景点的特征
				
				//按景区特征(s)搜索
				//相关代码......
				Cursor cursor;
				cursor = db.rawQuery("select * from 景点信息   where 特征1=? or 特征2=? or 特征3=?"
						, new String[] {s,s,s});
				if(cursor.getCount()==0)
				{
					s0="";
				}
				else
				{
					cursor.moveToFirst();
					s0=cursor.getString(0);
					s=cursor.getString(1);
					s1=cursor.getString(2);
					s2=cursor.getString(3);
					s3=cursor.getString(4);
					s4=cursor.getString(5);
				}
				//如果为空
				if(s0.isEmpty())
				{
			        message="对不起，未找到相关景点！";
			        ShowDialog(source);
			        s=null;
			        return;
				}
				//否则更新s,s0,s1,s2,s3,s4(s0为“ID”——用于显示图片，s1/s2/s3为介绍1、2、3,s4为视频对应的链接)
				
			    for(i=0;i<10;i++)  //判断输入的景区是否为列表中的景区
			       {
			            if(s.equals(view[i].getText().toString()))
			            {
			                view[i].setTextColor(0xffccff33);
			                j=view[i];
			                Intent intent=new Intent();
			                intent.putExtra("name", s);   //传递搜索景区的名称
			                intent.putExtra("ID", s0);   //传递搜索景区的ID
			                intent.putExtra("intro1", s1);  //传递搜索景区的介绍1
			                intent.putExtra("intro2", s2);  //传递搜索景区的介绍2
			                intent.putExtra("intro3", s3);  //传递搜索景区的介绍3
			                intent.putExtra("shipin", s4);  //传递搜索景区的视频链接
			                intent.setClass(search.this, Introduce.class);
			                startActivity(intent);
			            }
			       }
			}
			}
		});}

	public void ShowDialog(View source)
	{
	    //创建对话框  
	    new AlertDialog.Builder(this)  
	    .setTitle("SORRY")  //设置对话框标题  
      .setMessage(message)
      .setIcon(R.drawable.sorry)
	    .setPositiveButton("确定", null)    //设置对话框[否定]按钮  
	    .create()
	    .show();  
	}  
	 
	@Override
	protected Dialog onCreateDialog(int id) {
		RecognizerDialog recognizerDialog = new RecognizerDialog(
				search.this, "appid=51db75c0");// 这里应该写从科大讯飞申请到的appid
		recognizerDialog.setEngine("sms", null, null);
		recognizerDialog.setListener(new RecognizerDialogListener() {
			@Override
			public void onResults(ArrayList<RecognizerResult> results,
					boolean arg1) {
				StringBuffer result = new StringBuffer();
				for (RecognizerResult r : results) {
					result.append(r.text);
				}
				String get=result.toString();
				editText.setText(get.substring(0,get.length()-1));
			}

			@Override
			public void onEnd(SpeechError arg0) {

			}
		});
		return recognizerDialog;
	}
	
	OnClickListener on=new OnClickListener()
	{
		public void onClick(View v)
		{
			TextView viewx=(TextView)findViewById(v.getId());
			j.setTextColor(0xff000000);
			viewx.setTextColor(0xffccff33);
	        editText.setText(viewx.getText());
	        j=viewx;
		   
	        //用于点击景点直接跳出介绍的代码，但一旦加入则出错，原因不明
	        //在数据库中查询相关景点view[0]的相关介绍，返回s,s0,s1,s2,s3,s4
	        s=viewx.getText().toString();
	        Cursor cursor;
			cursor = db.rawQuery("select * from 景点信息   where name=?"
					, new String[] {s});
			if(cursor.getCount()==0)
			{
				s0="";
			}
			else
			{
				cursor.moveToFirst();
				s0=cursor.getString(0);
				s=cursor.getString(1);
				s1=cursor.getString(2);
				s2=cursor.getString(3);
				s3=cursor.getString(4);
				s4=cursor.getString(5);
			}
			
			Intent intent=new Intent();
	        intent.putExtra("name", s);   //传递搜索景区的名称
	        intent.putExtra("intro1", s1);  //传递搜索景区的介绍1
	        intent.putExtra("intro2", s2);  //传递搜索景区的介绍2
	        intent.putExtra("intro3", s3);  //传递搜索景区的介绍3
	        intent.putExtra("shipin", s4);  //传递搜索景区的视频链接
	        intent.putExtra("ID", s0);   //传递搜索景区的ID
	        intent.setClass(search.this, Introduce.class);
	        startActivity(intent);
		}
	};
	}

//不能直接用for循环为景点对应的TextView添加setOnClickListener(在onClick函数直接写在new OnClickListener()中时)，
//即使用匿名类时，会出各种错，原因不明，但如果不用匿名类好像就可以循环添加setOnClickListener
/*for(i=0;i<=8;i++)  //此处不能为9，会死机，原因不明
{
	view[i].setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			view[j].setTextColor(0xffc0c0c0);
			view[i].setTextColor(0xffccff33);
		    editText.setText(view[i].getText());
		    j=i;
		    }
	});
}*/
