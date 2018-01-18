package com.gs.gscartoon.kuaikan.bean;

import java.util.List;

/**
 * Created by camdora on 18-1-18.
 */

public class KuaiKanBrowseBean {

    /**
     * code : 200
     * data : {"comment_view_message":"吐槽神马的尽管来","can_view":true,"cover_image_url":"http://f2.kkmh.com/image/180117/rPLbNiw2A.webp-w640","created_at":1516225848,"is_favourite":false,"title":"第54话 男神的\u201c真面目\u201d？","recommend_count":0,"updated_at":1516159180,"selling_kk_currency":0,"zoomable":1,"push_flag":0,"previous_comic_id":70444,"share":{"award":false,"activity_id":null,"show_draw_record":false,"title":""},"customized_share":[],"id":71336,"comic_type":0,"is_login":false,"is_liked":false,"images":["http://f2.kkmh.com/image/c71336/180117/h4jWMQa6c.webp-w640","http://f2.kkmh.com/image/c71336/180117/PLXHj8yEA.webp-w640","http://f2.kkmh.com/image/c71336/180117/nnifstAGJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/VLu6GRMNs.webp-w640","http://f2.kkmh.com/image/c71336/180117/EsolAUdYb.webp-w640","http://f2.kkmh.com/image/c71336/180117/Jw3yn76S6.webp-w640","http://f2.kkmh.com/image/c71336/180117/mAQ7N41EB.webp-w640","http://f2.kkmh.com/image/c71336/180117/ZSzNKysLm.webp-w640","http://f2.kkmh.com/image/c71336/180117/0ZpfHHWvq.webp-w640","http://f2.kkmh.com/image/c71336/180117/cQ1Z9u59G.webp-w640","http://f2.kkmh.com/image/c71336/180117/0pAnpt4pL.webp-w640","http://f2.kkmh.com/image/c71336/180117/D0EsZfNhC.webp-w640","http://f2.kkmh.com/image/c71336/180117/D5VXBpgIF.webp-w640","http://f2.kkmh.com/image/c71336/180117/9IEv1TJPo.webp-w640","http://f2.kkmh.com/image/c71336/180117/4ZkZONdWT.webp-w640","http://f2.kkmh.com/image/c71336/180117/TaAM5sGrZ.webp-w640","http://f2.kkmh.com/image/c71336/180117/sebUArkal.webp-w640","http://f2.kkmh.com/image/c71336/180117/3tS4YVSHN.webp-w640","http://f2.kkmh.com/image/c71336/180117/FhHMVTBPO.webp-w640","http://f2.kkmh.com/image/c71336/180117/heHsmVxRk.webp-w640","http://f2.kkmh.com/image/c71336/180117/HrYljdPFd.webp-w640","http://f2.kkmh.com/image/c71336/180117/WEzSpaklw.webp-w640","http://f2.kkmh.com/image/c71336/180117/Ask30sOeJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/GOwvvjvOj.webp-w640","http://f2.kkmh.com/image/c71336/180117/UuYpAtgid.webp-w640","http://f2.kkmh.com/image/c71336/180117/n1R3m2IIx.webp-w640","http://f2.kkmh.com/image/c71336/180117/ZE0mxk2pf.webp-w640","http://f2.kkmh.com/image/c71336/180117/TlNiCzTqH.webp-w640","http://f2.kkmh.com/image/c71336/180117/NzkeDa8jC.webp-w640","http://f2.kkmh.com/image/c71336/180117/vb9xAZxQ0.webp-w640","http://f2.kkmh.com/image/c71336/180117/DDO2TXNLE.webp-w640","http://f2.kkmh.com/image/c71336/180117/bpFzta1eJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/N1gqfLGzP.webp-w640","http://f2.kkmh.com/image/c71336/180117/3kzxOOp40.webp-w640","http://f2.kkmh.com/image/c71336/180117/gtHvxxXuC.webp-w640","http://f2.kkmh.com/image/c71336/180117/zdDXLTUJF.webp-w640","http://f2.kkmh.com/image/c71336/180117/zuPde9mbT.webp-w640","http://f2.kkmh.com/image/c71336/180117/CdP8WFQ58.webp-w640","http://f2.kkmh.com/image/c71336/180117/eEQcSaAxg.webp-w640","http://f2.kkmh.com/image/c71336/180117/ofnwiycm7.webp-w640","http://f2.kkmh.com/image/c71336/180117/NIh0OD9Qk.webp-w640","http://f2.kkmh.com/image/c71336/180117/ttX3f1dHO.webp-w640","http://f2.kkmh.com/image/c71336/180117/L5q4xm2kP.webp-w640","http://f2.kkmh.com/image/c71336/180117/eCXnkRef9.webp-w640","http://f2.kkmh.com/image/c71336/180117/Y2UFtfExe.webp-w640","http://f2.kkmh.com/image/c71336/180117/34AotUY9H.webp-w640","http://f2.kkmh.com/image/c71336/180117/h2yzuZGwO.webp-w640","http://f2.kkmh.com/image/c71336/180117/XOnZmKKI9.webp-w640","http://f2.kkmh.com/image/c71336/180117/gNAU0It9t.webp-w640","http://f2.kkmh.com/image/c71336/180117/c43F29cJO.webp-w640","http://f2.kkmh.com/image/c71336/180117/dZ3MaHIqw.webp-w640","http://f2.kkmh.com/image/c71336/180117/i4yJM1cgG.webp-w640","http://f2.kkmh.com/image/c71336/180117/Wj1KPV5mG.webp-w640","http://f2.kkmh.com/image/c71336/180117/f6ojYdVBp.webp-w640","http://f2.kkmh.com/image/c71336/180117/ieI7mmcvw.webp-w640","http://f2.kkmh.com/image/c71336/180117/AqOavbqiz.webp-w640","http://f2.kkmh.com/image/c71336/180117/h0B35Y9bm.webp-w640","http://f2.kkmh.com/image/c71336/180117/f0nhvXv5G.webp-w640","http://f2.kkmh.com/image/c71336/180117/mK4WEwXNb.webp-w640","http://f2.kkmh.com/image/c71336/180117/E0K9T41xB.webp-w640","http://f2.kkmh.com/image/c71336/180117/qnnbTySJh.webp-w640","http://f2.kkmh.com/image/c71336/180117/PtntcZEgE.webp-w640","http://f2.kkmh.com/image/c71336/180117/KGTAJHfKs.webp-w640","http://f2.kkmh.com/image/c71336/180117/Vg2wKrzsC.webp-w640","http://f2.kkmh.com/image/c71336/180117/YUN9HulzD.webp-w640","http://f2.kkmh.com/image/c71336/180117/DPNznfW3T.webp-w640","http://f2.kkmh.com/image/c71336/180117/fTHQwb4CO.webp-w640","http://f2.kkmh.com/image/c71336/180117/5yBX8rsS8.webp-w640","http://f2.kkmh.com/image/c71336/180117/HJVnvJSn1.webp-w640","http://f2.kkmh.com/image/c71336/180117/YP3UAjplj.webp-w640","http://f2.kkmh.com/image/c71336/180117/CUF1e5o8w.webp-w640","http://f2.kkmh.com/image/c71336/180117/zeL0MuMH5.webp-w640","http://f2.kkmh.com/image/c71336/180117/4cspS9Viq.webp-w640","http://f2.kkmh.com/image/c71336/180117/GJ4m6S121.webp-w640","http://f2.kkmh.com/image/c71336/180117/wJS37t30u.webp-w640","http://f2.kkmh.com/image/c71336/180117/6q6I1Zg9N.webp-w640","http://f2.kkmh.com/image/c71336/180117/OeVOV4M8u.webp-w640","http://f2.kkmh.com/image/c71336/180117/iG7WCIlHO.webp-w640","http://f2.kkmh.com/image/c71336/180117/eR9Pf4Gup.webp-w640","http://f2.kkmh.com/image/c71336/180117/YGdgtgqSM.webp-w640","http://f2.kkmh.com/image/c71336/180117/aaTWlUWRJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/cOeho8TGm.webp-w640","http://f2.kkmh.com/image/c71336/180117/cjsPF0LOn.webp-w640","http://f2.kkmh.com/image/c71336/180117/36LOFlUbc.webp-w640","http://f2.kkmh.com/image/c71336/180117/b5xhPQvEG.webp-w640","http://f2.kkmh.com/image/c71336/180117/S8sRXvkKZ.webp-w640","http://f2.kkmh.com/image/c71336/180117/9qEOEWpRG.webp-w640","http://f2.kkmh.com/image/c71336/180117/Tiy4YZU6a.webp-w640","http://f2.kkmh.com/image/c71336/180117/pcCEEgE0r.webp-w640","http://f2.kkmh.com/image/c71336/180117/ECqsDJj8P.webp-w640","http://f2.kkmh.com/image/c71336/180117/fgDXt3ToX.webp-w640","http://f2.kkmh.com/image/c71336/180117/U29MtRoS2.webp-w640","http://f2.kkmh.com/image/c71336/180117/8GvZfrKdj.webp-w640","http://f2.kkmh.com/image/c71336/180117/1ouWFurV2.webp-w640","http://f2.kkmh.com/image/c71336/180117/LYqW5RlDU.webp-w640","http://f2.kkmh.com/image/c71336/180117/x4CLITVOD.webp-w640"],"tencent_share_title":"最近发现一部超好看的漫画:当校霸爱上学霸","storyboard_cnt":50,"image_infos":[{"width":1280,"key":"41051882dd3404d4f0d1a5adb0f59edb","height":1000},{"width":1280,"key":"82b19a4580efa3dd77d8e7cf4c0eab2a","height":1000},{"width":1280,"key":"f04204fcaf011a03a075d4fc28a7cb97","height":1000},{"width":1280,"key":"757d6ca53e97cb1b3eb32f4c7eb39185","height":1000},{"width":1280,"key":"eec4e808e95663fe53f3ecee08721543","height":1000},{"width":1280,"key":"a9a0070757ff5c4c6ad05adf97a02c94","height":1000},{"width":1280,"key":"4c122574b5adb3f1897004384c3b848d","height":1000},{"width":1280,"key":"767d82057e698dcc07ff2538dbeea5aa","height":1000},{"width":1280,"key":"32929395999dd18dd2922a247ec8fcf2","height":1000},{"width":1280,"key":"74ab226070b632f74d179f2cb3364b71","height":1000},{"width":1280,"key":"be1ba8d4dc2ac638dee2467f42bd809b","height":1000},{"width":1280,"key":"c255d1fffc60fdd8de55ec21518e7260","height":1000},{"width":1280,"key":"db66cc87edae04d87446463d9ecf04a1","height":1000},{"width":1280,"key":"8cfb5b7da9d7766bb188b93453f9a5e7","height":1000},{"width":1280,"key":"3e1c4f77216a6fa1fe9ad41463b45146","height":1000},{"width":1280,"key":"fc6773ee3a0969d4c00475e38d870da2","height":1000},{"width":1280,"key":"b5fe5ddeef5f84374c446e3c9d89ad75","height":1000},{"width":1280,"key":"b2ef5617a1df4ed06ae8aa84f0204d90","height":1000},{"width":1280,"key":"72f598d9e46eab02f8b6ea9cd0152620","height":1000},{"width":1280,"key":"2e67da73903ffc7879db649794e9b32a","height":1000},{"width":1280,"key":"5370e22c0f2541028d937ebf8ccdcd65","height":1000},{"width":1280,"key":"9f87b1bc1cd58384e3a0783350338f46","height":1000},{"width":1280,"key":"d45c7e81328a86704409aff22a0b452e","height":1000},{"width":1280,"key":"91c213fdea4fe5d7e0496f5f07670011","height":1000},{"width":1280,"key":"bebf4f142d197bc44c7a5d5841e11f03","height":1000},{"width":1280,"key":"59464f1372be77c0de644bbad1a7d218","height":1000},{"width":1280,"key":"65be4688df4ec015bb0b2a51ebf2e6d8","height":1000},{"width":1280,"key":"500de156c37be2d8790de71e0e091717","height":1000},{"width":1280,"key":"00baa8d06354e8d96ccef6e6c0caef05","height":1000},{"width":1280,"key":"9e4d24f88ad61105c2ab82c32bf3f106","height":1000},{"width":1280,"key":"001837fef2a7a7234d1baa4333ef9c96","height":1000},{"width":1280,"key":"2ffadb8062b876429e6a9737e9a04459","height":1000},{"width":1280,"key":"eff46a56501929565030088cd0a15bfd","height":1000},{"width":1280,"key":"71e9b4bfd0a9bcab7e763c8eae342951","height":1000},{"width":1280,"key":"283d4d6e113886d9a861c369a16d6b99","height":1000},{"width":1280,"key":"63aecc87463e437a4a69ce8446af25e9","height":1000},{"width":1280,"key":"4e56021023e68f63daa4afc088ea2ab5","height":1000},{"width":1280,"key":"e255f992c73ab769bba56910619351d9","height":1000},{"width":1280,"key":"10540d88eccdc336ed544b57f00bb28b","height":1000},{"width":1280,"key":"824b3eb4620b183ea247c023ffd09026","height":1000},{"width":1280,"key":"aa9817738bf4c5e5598a872964a20b6f","height":1000},{"width":1280,"key":"895a926d587c8d69ad4eefee5cdee5f6","height":1000},{"width":1280,"key":"0b6aa26f9bf50e72d4c0a3a0180deca7","height":1000},{"width":1280,"key":"b61dd0043dd5ecc661c45fdc04796f01","height":1000},{"width":1280,"key":"997cc624c231b641822325fa647df60e","height":1000},{"width":1280,"key":"1cb4a440ed8548b8bf1a0b7377d16391","height":1000},{"width":1280,"key":"2a8edb4376c3b878d3179e19fb67da1c","height":1000},{"width":1280,"key":"90b60c8ad1f9ee3285cbb2c6ce44555c","height":1000},{"width":1280,"key":"919f8bdc38f5880bf14ed708165c4256","height":1000},{"width":1280,"key":"3c15b5a4bcc4bad4de96467e222f80b8","height":1000},{"width":1280,"key":"228c928a6b89dda9ccdff11c7dd3204b","height":1000},{"width":1280,"key":"1d88718fa713cc1d29b190480b7f1b83","height":1000},{"width":1280,"key":"4b3e241358010d3df619629e2b4e54ae","height":1000},{"width":1280,"key":"b9ea34e7c7ef8979dc2816bce823e26d","height":1000},{"width":1280,"key":"55853beecadd6b69292e218f11fed6e9","height":1000},{"width":1280,"key":"b14cc25c46e23aef6dc0513e8c470cd8","height":1000},{"width":1280,"key":"ac99e0e8c6a19b38642d5afcb12b4cde","height":1000},{"width":1280,"key":"25e5cf47f737e67631d6859b2cf96b9f","height":1000},{"width":1280,"key":"29d52d66fb72286e13033a3820edd6bc","height":1000},{"width":1280,"key":"8305a45584fc227f2f38b4bf21103bfc","height":1000},{"width":1280,"key":"e59ea0896a5a3c86be3085661f219b11","height":1000},{"width":1280,"key":"50c2691ecc9d9868efd81ee5725ea6e2","height":1000},{"width":1280,"key":"ee935e3ac659cdfa8a81b9a62c3e9f63","height":1000},{"width":1280,"key":"6b34af35b9d2d0497bbd3be2712574de","height":1000},{"width":1280,"key":"cff58e9a602e1bb2124a534dc1ec3b89","height":1000},{"width":1280,"key":"ae63bd2c8d7ad3294e2e9a3aef85eb05","height":1000},{"width":1280,"key":"bfd281995f79ec26d8f3c54602904fe8","height":1000},{"width":1280,"key":"ca8b53d74ca159d17f04ca5734081d5a","height":1000},{"width":1280,"key":"1330b10bcf0aab2786e58cfc2e9fad49","height":1000},{"width":1280,"key":"0dd1c74f138bb7380775bb275a83a597","height":1000},{"width":1280,"key":"a0c84e91bb218400b2ffae7475f0df99","height":1000},{"width":1280,"key":"cd058333ffd29f35a991d625c4f8db19","height":1000},{"width":1280,"key":"d441e7ec51010a19a99d982b9706a317","height":1000},{"width":1280,"key":"ce38b482e445d1b8941222fb2138a298","height":1000},{"width":1280,"key":"8e537a68b64de914d2c78b5c0e15a766","height":1000},{"width":1280,"key":"69f96a935346a3eb05183360b4215640","height":1000},{"width":1280,"key":"b2552cf19967302dde1a671ef115a3b7","height":1000},{"width":1280,"key":"fbf779d4dadb35cdad394eb4a3ae2990","height":1000},{"width":1280,"key":"b588e317b1a750a6f2766440e9fd4721","height":1000},{"width":1280,"key":"a8d9f2393ac0f654be67930be625843e","height":1000},{"width":1280,"key":"17d0915b79b6491088fef932abbed5e8","height":1000},{"width":1280,"key":"d981f6bda4aa69305cb6a2f9f9117aba","height":1000},{"width":1280,"key":"f79ecf3ae38aea58f57d305ed6a076e6","height":1000},{"width":1280,"key":"b770ed6062648d814cb872140e482733","height":1000},{"width":1280,"key":"1513622fe3d58f41c03eafc3aa517be6","height":1000},{"width":1280,"key":"5e0f8642247a53e5a745d3b7d726e2f7","height":1000},{"width":1280,"key":"977e8c3711adc0eb36d506dfcf32fc3b","height":1000},{"width":1280,"key":"dadb1edcc760d9439a7acc55b7a120f2","height":1000},{"width":1280,"key":"b12a5e55047c08114034a20340be6c9c","height":1000},{"width":1280,"key":"521df434afa60ce58a33b852b03b205e","height":1000},{"width":1280,"key":"b77121245517f7fe3181c1f4e81b7af6","height":1000},{"width":1280,"key":"fbb1bdf80135291976ba573984a1ba85","height":1000},{"width":1280,"key":"eef223555caa0e7f7fb00fe7c7a05400","height":1000},{"width":1280,"key":"b1e8a96751be1418ff473a72c1d3e4c0","height":1000},{"width":1280,"key":"1d240ff047bc4db965b5bbd2f10f9c21","height":1000},{"width":1280,"key":"6487db9561bce3c02228da82526d471b","height":1000}],"next_comic_id":null,"sina_share_title":"最近在@快看漫画 上发现一部超好看的漫画:当校霸爱上学霸,和我一起来看吧~完整内容戳:","url":"http://m.kuaikanmanhua.com/comics/71336","likes_count":80687,"banner_info":{"type":0},"tencent_share_params":"快看!一分钟一个超赞故事!","comments_count":1635,"is_free":true,"topic":{"discover_image_url":"","vertical_image_url":"http://f2.kkmh.com/image/161226/th1gzi9gn.webp-w320","cover_image_url":"http://f2.kkmh.com/image/161226/0nk746yec.webp-w640","description":"武力值MAX的道场继承人\u2014\u2014向小满，为了追男神，决定江湖洗手，转校做一个安安静静的柔弱女子。而未曾想到的是，踏入校园第一天，男神还没追到，却因超凡的战斗力，被学校不良少年误认为男神。究竟小满能否成为男神心中的理想型，顺利转变现有的画风呢？【独家/每周四更新 责编：羊】","created_at":1482734574,"is_favourite":false,"title":"当校霸爱上学霸","male_vertical_image_url":"http://f2.kkmh.com/image/161226/th1gzi9gn.webp-w320","updated_at":1482734574,"special_offer":{},"is_free":true,"id":991,"related_authors":[{"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180","grade":1,"nickname":"灿灿 ","reg_type":"weibo","id":28863310},{"pub_feed":0,"avatar_url":"http://f2.kkmh.com/default_avatar_image.jpg-w180","grade":1,"nickname":"夏天岛","reg_type":"weibo","id":96094336}],"user":{"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180","grade":1,"nickname":"灿灿 ","reg_type":"weibo","id":28863310},"label_id":44,"male_cover_image_url":"http://f2.kkmh.com/image/161226/0nk746yec.webp-w640","order":480,"comics_count":58,"status":"published"},"serial_no":0,"status":"published"}
     * message : ok
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * comment_view_message : 吐槽神马的尽管来
         * can_view : true
         * cover_image_url : http://f2.kkmh.com/image/180117/rPLbNiw2A.webp-w640
         * created_at : 1516225848
         * is_favourite : false
         * title : 第54话 男神的“真面目”？
         * recommend_count : 0
         * updated_at : 1516159180
         * selling_kk_currency : 0
         * zoomable : 1
         * push_flag : 0
         * previous_comic_id : 70444
         * share : {"award":false,"activity_id":null,"show_draw_record":false,"title":""}
         * customized_share : []
         * id : 71336
         * comic_type : 0
         * is_login : false
         * is_liked : false
         * images : ["http://f2.kkmh.com/image/c71336/180117/h4jWMQa6c.webp-w640","http://f2.kkmh.com/image/c71336/180117/PLXHj8yEA.webp-w640","http://f2.kkmh.com/image/c71336/180117/nnifstAGJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/VLu6GRMNs.webp-w640","http://f2.kkmh.com/image/c71336/180117/EsolAUdYb.webp-w640","http://f2.kkmh.com/image/c71336/180117/Jw3yn76S6.webp-w640","http://f2.kkmh.com/image/c71336/180117/mAQ7N41EB.webp-w640","http://f2.kkmh.com/image/c71336/180117/ZSzNKysLm.webp-w640","http://f2.kkmh.com/image/c71336/180117/0ZpfHHWvq.webp-w640","http://f2.kkmh.com/image/c71336/180117/cQ1Z9u59G.webp-w640","http://f2.kkmh.com/image/c71336/180117/0pAnpt4pL.webp-w640","http://f2.kkmh.com/image/c71336/180117/D0EsZfNhC.webp-w640","http://f2.kkmh.com/image/c71336/180117/D5VXBpgIF.webp-w640","http://f2.kkmh.com/image/c71336/180117/9IEv1TJPo.webp-w640","http://f2.kkmh.com/image/c71336/180117/4ZkZONdWT.webp-w640","http://f2.kkmh.com/image/c71336/180117/TaAM5sGrZ.webp-w640","http://f2.kkmh.com/image/c71336/180117/sebUArkal.webp-w640","http://f2.kkmh.com/image/c71336/180117/3tS4YVSHN.webp-w640","http://f2.kkmh.com/image/c71336/180117/FhHMVTBPO.webp-w640","http://f2.kkmh.com/image/c71336/180117/heHsmVxRk.webp-w640","http://f2.kkmh.com/image/c71336/180117/HrYljdPFd.webp-w640","http://f2.kkmh.com/image/c71336/180117/WEzSpaklw.webp-w640","http://f2.kkmh.com/image/c71336/180117/Ask30sOeJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/GOwvvjvOj.webp-w640","http://f2.kkmh.com/image/c71336/180117/UuYpAtgid.webp-w640","http://f2.kkmh.com/image/c71336/180117/n1R3m2IIx.webp-w640","http://f2.kkmh.com/image/c71336/180117/ZE0mxk2pf.webp-w640","http://f2.kkmh.com/image/c71336/180117/TlNiCzTqH.webp-w640","http://f2.kkmh.com/image/c71336/180117/NzkeDa8jC.webp-w640","http://f2.kkmh.com/image/c71336/180117/vb9xAZxQ0.webp-w640","http://f2.kkmh.com/image/c71336/180117/DDO2TXNLE.webp-w640","http://f2.kkmh.com/image/c71336/180117/bpFzta1eJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/N1gqfLGzP.webp-w640","http://f2.kkmh.com/image/c71336/180117/3kzxOOp40.webp-w640","http://f2.kkmh.com/image/c71336/180117/gtHvxxXuC.webp-w640","http://f2.kkmh.com/image/c71336/180117/zdDXLTUJF.webp-w640","http://f2.kkmh.com/image/c71336/180117/zuPde9mbT.webp-w640","http://f2.kkmh.com/image/c71336/180117/CdP8WFQ58.webp-w640","http://f2.kkmh.com/image/c71336/180117/eEQcSaAxg.webp-w640","http://f2.kkmh.com/image/c71336/180117/ofnwiycm7.webp-w640","http://f2.kkmh.com/image/c71336/180117/NIh0OD9Qk.webp-w640","http://f2.kkmh.com/image/c71336/180117/ttX3f1dHO.webp-w640","http://f2.kkmh.com/image/c71336/180117/L5q4xm2kP.webp-w640","http://f2.kkmh.com/image/c71336/180117/eCXnkRef9.webp-w640","http://f2.kkmh.com/image/c71336/180117/Y2UFtfExe.webp-w640","http://f2.kkmh.com/image/c71336/180117/34AotUY9H.webp-w640","http://f2.kkmh.com/image/c71336/180117/h2yzuZGwO.webp-w640","http://f2.kkmh.com/image/c71336/180117/XOnZmKKI9.webp-w640","http://f2.kkmh.com/image/c71336/180117/gNAU0It9t.webp-w640","http://f2.kkmh.com/image/c71336/180117/c43F29cJO.webp-w640","http://f2.kkmh.com/image/c71336/180117/dZ3MaHIqw.webp-w640","http://f2.kkmh.com/image/c71336/180117/i4yJM1cgG.webp-w640","http://f2.kkmh.com/image/c71336/180117/Wj1KPV5mG.webp-w640","http://f2.kkmh.com/image/c71336/180117/f6ojYdVBp.webp-w640","http://f2.kkmh.com/image/c71336/180117/ieI7mmcvw.webp-w640","http://f2.kkmh.com/image/c71336/180117/AqOavbqiz.webp-w640","http://f2.kkmh.com/image/c71336/180117/h0B35Y9bm.webp-w640","http://f2.kkmh.com/image/c71336/180117/f0nhvXv5G.webp-w640","http://f2.kkmh.com/image/c71336/180117/mK4WEwXNb.webp-w640","http://f2.kkmh.com/image/c71336/180117/E0K9T41xB.webp-w640","http://f2.kkmh.com/image/c71336/180117/qnnbTySJh.webp-w640","http://f2.kkmh.com/image/c71336/180117/PtntcZEgE.webp-w640","http://f2.kkmh.com/image/c71336/180117/KGTAJHfKs.webp-w640","http://f2.kkmh.com/image/c71336/180117/Vg2wKrzsC.webp-w640","http://f2.kkmh.com/image/c71336/180117/YUN9HulzD.webp-w640","http://f2.kkmh.com/image/c71336/180117/DPNznfW3T.webp-w640","http://f2.kkmh.com/image/c71336/180117/fTHQwb4CO.webp-w640","http://f2.kkmh.com/image/c71336/180117/5yBX8rsS8.webp-w640","http://f2.kkmh.com/image/c71336/180117/HJVnvJSn1.webp-w640","http://f2.kkmh.com/image/c71336/180117/YP3UAjplj.webp-w640","http://f2.kkmh.com/image/c71336/180117/CUF1e5o8w.webp-w640","http://f2.kkmh.com/image/c71336/180117/zeL0MuMH5.webp-w640","http://f2.kkmh.com/image/c71336/180117/4cspS9Viq.webp-w640","http://f2.kkmh.com/image/c71336/180117/GJ4m6S121.webp-w640","http://f2.kkmh.com/image/c71336/180117/wJS37t30u.webp-w640","http://f2.kkmh.com/image/c71336/180117/6q6I1Zg9N.webp-w640","http://f2.kkmh.com/image/c71336/180117/OeVOV4M8u.webp-w640","http://f2.kkmh.com/image/c71336/180117/iG7WCIlHO.webp-w640","http://f2.kkmh.com/image/c71336/180117/eR9Pf4Gup.webp-w640","http://f2.kkmh.com/image/c71336/180117/YGdgtgqSM.webp-w640","http://f2.kkmh.com/image/c71336/180117/aaTWlUWRJ.webp-w640","http://f2.kkmh.com/image/c71336/180117/cOeho8TGm.webp-w640","http://f2.kkmh.com/image/c71336/180117/cjsPF0LOn.webp-w640","http://f2.kkmh.com/image/c71336/180117/36LOFlUbc.webp-w640","http://f2.kkmh.com/image/c71336/180117/b5xhPQvEG.webp-w640","http://f2.kkmh.com/image/c71336/180117/S8sRXvkKZ.webp-w640","http://f2.kkmh.com/image/c71336/180117/9qEOEWpRG.webp-w640","http://f2.kkmh.com/image/c71336/180117/Tiy4YZU6a.webp-w640","http://f2.kkmh.com/image/c71336/180117/pcCEEgE0r.webp-w640","http://f2.kkmh.com/image/c71336/180117/ECqsDJj8P.webp-w640","http://f2.kkmh.com/image/c71336/180117/fgDXt3ToX.webp-w640","http://f2.kkmh.com/image/c71336/180117/U29MtRoS2.webp-w640","http://f2.kkmh.com/image/c71336/180117/8GvZfrKdj.webp-w640","http://f2.kkmh.com/image/c71336/180117/1ouWFurV2.webp-w640","http://f2.kkmh.com/image/c71336/180117/LYqW5RlDU.webp-w640","http://f2.kkmh.com/image/c71336/180117/x4CLITVOD.webp-w640"]
         * tencent_share_title : 最近发现一部超好看的漫画:当校霸爱上学霸
         * storyboard_cnt : 50
         * image_infos : [{"width":1280,"key":"41051882dd3404d4f0d1a5adb0f59edb","height":1000},{"width":1280,"key":"82b19a4580efa3dd77d8e7cf4c0eab2a","height":1000},{"width":1280,"key":"f04204fcaf011a03a075d4fc28a7cb97","height":1000},{"width":1280,"key":"757d6ca53e97cb1b3eb32f4c7eb39185","height":1000},{"width":1280,"key":"eec4e808e95663fe53f3ecee08721543","height":1000},{"width":1280,"key":"a9a0070757ff5c4c6ad05adf97a02c94","height":1000},{"width":1280,"key":"4c122574b5adb3f1897004384c3b848d","height":1000},{"width":1280,"key":"767d82057e698dcc07ff2538dbeea5aa","height":1000},{"width":1280,"key":"32929395999dd18dd2922a247ec8fcf2","height":1000},{"width":1280,"key":"74ab226070b632f74d179f2cb3364b71","height":1000},{"width":1280,"key":"be1ba8d4dc2ac638dee2467f42bd809b","height":1000},{"width":1280,"key":"c255d1fffc60fdd8de55ec21518e7260","height":1000},{"width":1280,"key":"db66cc87edae04d87446463d9ecf04a1","height":1000},{"width":1280,"key":"8cfb5b7da9d7766bb188b93453f9a5e7","height":1000},{"width":1280,"key":"3e1c4f77216a6fa1fe9ad41463b45146","height":1000},{"width":1280,"key":"fc6773ee3a0969d4c00475e38d870da2","height":1000},{"width":1280,"key":"b5fe5ddeef5f84374c446e3c9d89ad75","height":1000},{"width":1280,"key":"b2ef5617a1df4ed06ae8aa84f0204d90","height":1000},{"width":1280,"key":"72f598d9e46eab02f8b6ea9cd0152620","height":1000},{"width":1280,"key":"2e67da73903ffc7879db649794e9b32a","height":1000},{"width":1280,"key":"5370e22c0f2541028d937ebf8ccdcd65","height":1000},{"width":1280,"key":"9f87b1bc1cd58384e3a0783350338f46","height":1000},{"width":1280,"key":"d45c7e81328a86704409aff22a0b452e","height":1000},{"width":1280,"key":"91c213fdea4fe5d7e0496f5f07670011","height":1000},{"width":1280,"key":"bebf4f142d197bc44c7a5d5841e11f03","height":1000},{"width":1280,"key":"59464f1372be77c0de644bbad1a7d218","height":1000},{"width":1280,"key":"65be4688df4ec015bb0b2a51ebf2e6d8","height":1000},{"width":1280,"key":"500de156c37be2d8790de71e0e091717","height":1000},{"width":1280,"key":"00baa8d06354e8d96ccef6e6c0caef05","height":1000},{"width":1280,"key":"9e4d24f88ad61105c2ab82c32bf3f106","height":1000},{"width":1280,"key":"001837fef2a7a7234d1baa4333ef9c96","height":1000},{"width":1280,"key":"2ffadb8062b876429e6a9737e9a04459","height":1000},{"width":1280,"key":"eff46a56501929565030088cd0a15bfd","height":1000},{"width":1280,"key":"71e9b4bfd0a9bcab7e763c8eae342951","height":1000},{"width":1280,"key":"283d4d6e113886d9a861c369a16d6b99","height":1000},{"width":1280,"key":"63aecc87463e437a4a69ce8446af25e9","height":1000},{"width":1280,"key":"4e56021023e68f63daa4afc088ea2ab5","height":1000},{"width":1280,"key":"e255f992c73ab769bba56910619351d9","height":1000},{"width":1280,"key":"10540d88eccdc336ed544b57f00bb28b","height":1000},{"width":1280,"key":"824b3eb4620b183ea247c023ffd09026","height":1000},{"width":1280,"key":"aa9817738bf4c5e5598a872964a20b6f","height":1000},{"width":1280,"key":"895a926d587c8d69ad4eefee5cdee5f6","height":1000},{"width":1280,"key":"0b6aa26f9bf50e72d4c0a3a0180deca7","height":1000},{"width":1280,"key":"b61dd0043dd5ecc661c45fdc04796f01","height":1000},{"width":1280,"key":"997cc624c231b641822325fa647df60e","height":1000},{"width":1280,"key":"1cb4a440ed8548b8bf1a0b7377d16391","height":1000},{"width":1280,"key":"2a8edb4376c3b878d3179e19fb67da1c","height":1000},{"width":1280,"key":"90b60c8ad1f9ee3285cbb2c6ce44555c","height":1000},{"width":1280,"key":"919f8bdc38f5880bf14ed708165c4256","height":1000},{"width":1280,"key":"3c15b5a4bcc4bad4de96467e222f80b8","height":1000},{"width":1280,"key":"228c928a6b89dda9ccdff11c7dd3204b","height":1000},{"width":1280,"key":"1d88718fa713cc1d29b190480b7f1b83","height":1000},{"width":1280,"key":"4b3e241358010d3df619629e2b4e54ae","height":1000},{"width":1280,"key":"b9ea34e7c7ef8979dc2816bce823e26d","height":1000},{"width":1280,"key":"55853beecadd6b69292e218f11fed6e9","height":1000},{"width":1280,"key":"b14cc25c46e23aef6dc0513e8c470cd8","height":1000},{"width":1280,"key":"ac99e0e8c6a19b38642d5afcb12b4cde","height":1000},{"width":1280,"key":"25e5cf47f737e67631d6859b2cf96b9f","height":1000},{"width":1280,"key":"29d52d66fb72286e13033a3820edd6bc","height":1000},{"width":1280,"key":"8305a45584fc227f2f38b4bf21103bfc","height":1000},{"width":1280,"key":"e59ea0896a5a3c86be3085661f219b11","height":1000},{"width":1280,"key":"50c2691ecc9d9868efd81ee5725ea6e2","height":1000},{"width":1280,"key":"ee935e3ac659cdfa8a81b9a62c3e9f63","height":1000},{"width":1280,"key":"6b34af35b9d2d0497bbd3be2712574de","height":1000},{"width":1280,"key":"cff58e9a602e1bb2124a534dc1ec3b89","height":1000},{"width":1280,"key":"ae63bd2c8d7ad3294e2e9a3aef85eb05","height":1000},{"width":1280,"key":"bfd281995f79ec26d8f3c54602904fe8","height":1000},{"width":1280,"key":"ca8b53d74ca159d17f04ca5734081d5a","height":1000},{"width":1280,"key":"1330b10bcf0aab2786e58cfc2e9fad49","height":1000},{"width":1280,"key":"0dd1c74f138bb7380775bb275a83a597","height":1000},{"width":1280,"key":"a0c84e91bb218400b2ffae7475f0df99","height":1000},{"width":1280,"key":"cd058333ffd29f35a991d625c4f8db19","height":1000},{"width":1280,"key":"d441e7ec51010a19a99d982b9706a317","height":1000},{"width":1280,"key":"ce38b482e445d1b8941222fb2138a298","height":1000},{"width":1280,"key":"8e537a68b64de914d2c78b5c0e15a766","height":1000},{"width":1280,"key":"69f96a935346a3eb05183360b4215640","height":1000},{"width":1280,"key":"b2552cf19967302dde1a671ef115a3b7","height":1000},{"width":1280,"key":"fbf779d4dadb35cdad394eb4a3ae2990","height":1000},{"width":1280,"key":"b588e317b1a750a6f2766440e9fd4721","height":1000},{"width":1280,"key":"a8d9f2393ac0f654be67930be625843e","height":1000},{"width":1280,"key":"17d0915b79b6491088fef932abbed5e8","height":1000},{"width":1280,"key":"d981f6bda4aa69305cb6a2f9f9117aba","height":1000},{"width":1280,"key":"f79ecf3ae38aea58f57d305ed6a076e6","height":1000},{"width":1280,"key":"b770ed6062648d814cb872140e482733","height":1000},{"width":1280,"key":"1513622fe3d58f41c03eafc3aa517be6","height":1000},{"width":1280,"key":"5e0f8642247a53e5a745d3b7d726e2f7","height":1000},{"width":1280,"key":"977e8c3711adc0eb36d506dfcf32fc3b","height":1000},{"width":1280,"key":"dadb1edcc760d9439a7acc55b7a120f2","height":1000},{"width":1280,"key":"b12a5e55047c08114034a20340be6c9c","height":1000},{"width":1280,"key":"521df434afa60ce58a33b852b03b205e","height":1000},{"width":1280,"key":"b77121245517f7fe3181c1f4e81b7af6","height":1000},{"width":1280,"key":"fbb1bdf80135291976ba573984a1ba85","height":1000},{"width":1280,"key":"eef223555caa0e7f7fb00fe7c7a05400","height":1000},{"width":1280,"key":"b1e8a96751be1418ff473a72c1d3e4c0","height":1000},{"width":1280,"key":"1d240ff047bc4db965b5bbd2f10f9c21","height":1000},{"width":1280,"key":"6487db9561bce3c02228da82526d471b","height":1000}]
         * next_comic_id : null
         * sina_share_title : 最近在@快看漫画 上发现一部超好看的漫画:当校霸爱上学霸,和我一起来看吧~完整内容戳:
         * url : http://m.kuaikanmanhua.com/comics/71336
         * likes_count : 80687
         * banner_info : {"type":0}
         * tencent_share_params : 快看!一分钟一个超赞故事!
         * comments_count : 1635
         * is_free : true
         * topic : {"discover_image_url":"","vertical_image_url":"http://f2.kkmh.com/image/161226/th1gzi9gn.webp-w320","cover_image_url":"http://f2.kkmh.com/image/161226/0nk746yec.webp-w640","description":"武力值MAX的道场继承人\u2014\u2014向小满，为了追男神，决定江湖洗手，转校做一个安安静静的柔弱女子。而未曾想到的是，踏入校园第一天，男神还没追到，却因超凡的战斗力，被学校不良少年误认为男神。究竟小满能否成为男神心中的理想型，顺利转变现有的画风呢？【独家/每周四更新 责编：羊】","created_at":1482734574,"is_favourite":false,"title":"当校霸爱上学霸","male_vertical_image_url":"http://f2.kkmh.com/image/161226/th1gzi9gn.webp-w320","updated_at":1482734574,"special_offer":{},"is_free":true,"id":991,"related_authors":[{"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180","grade":1,"nickname":"灿灿 ","reg_type":"weibo","id":28863310},{"pub_feed":0,"avatar_url":"http://f2.kkmh.com/default_avatar_image.jpg-w180","grade":1,"nickname":"夏天岛","reg_type":"weibo","id":96094336}],"user":{"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180","grade":1,"nickname":"灿灿 ","reg_type":"weibo","id":28863310},"label_id":44,"male_cover_image_url":"http://f2.kkmh.com/image/161226/0nk746yec.webp-w640","order":480,"comics_count":58,"status":"published"}
         * serial_no : 0
         * status : published
         */

        private String comment_view_message;
        private boolean can_view;
        private String cover_image_url;
        private int created_at;
        private boolean is_favourite;
        private String title;
        private int recommend_count;
        private int updated_at;
        private int selling_kk_currency;
        private int zoomable;
        private int push_flag;
        private int previous_comic_id;
        private ShareBean share;
        private int id;
        private int comic_type;
        private boolean is_login;
        private boolean is_liked;
        private String tencent_share_title;
        private int storyboard_cnt;
        private Object next_comic_id;
        private String sina_share_title;
        private String url;
        private int likes_count;
        private BannerInfoBean banner_info;
        private String tencent_share_params;
        private int comments_count;
        private boolean is_free;
        private TopicBean topic;
        private int serial_no;
        private String status;
        private List<?> customized_share;
        private List<String> images;
        private List<ImageInfosBean> image_infos;

        public String getComment_view_message() {
            return comment_view_message;
        }

        public void setComment_view_message(String comment_view_message) {
            this.comment_view_message = comment_view_message;
        }

        public boolean isCan_view() {
            return can_view;
        }

        public void setCan_view(boolean can_view) {
            this.can_view = can_view;
        }

        public String getCover_image_url() {
            return cover_image_url;
        }

        public void setCover_image_url(String cover_image_url) {
            this.cover_image_url = cover_image_url;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public boolean isIs_favourite() {
            return is_favourite;
        }

        public void setIs_favourite(boolean is_favourite) {
            this.is_favourite = is_favourite;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getRecommend_count() {
            return recommend_count;
        }

        public void setRecommend_count(int recommend_count) {
            this.recommend_count = recommend_count;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public int getSelling_kk_currency() {
            return selling_kk_currency;
        }

        public void setSelling_kk_currency(int selling_kk_currency) {
            this.selling_kk_currency = selling_kk_currency;
        }

        public int getZoomable() {
            return zoomable;
        }

        public void setZoomable(int zoomable) {
            this.zoomable = zoomable;
        }

        public int getPush_flag() {
            return push_flag;
        }

        public void setPush_flag(int push_flag) {
            this.push_flag = push_flag;
        }

        public int getPrevious_comic_id() {
            return previous_comic_id;
        }

        public void setPrevious_comic_id(int previous_comic_id) {
            this.previous_comic_id = previous_comic_id;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getComic_type() {
            return comic_type;
        }

        public void setComic_type(int comic_type) {
            this.comic_type = comic_type;
        }

        public boolean isIs_login() {
            return is_login;
        }

        public void setIs_login(boolean is_login) {
            this.is_login = is_login;
        }

        public boolean isIs_liked() {
            return is_liked;
        }

        public void setIs_liked(boolean is_liked) {
            this.is_liked = is_liked;
        }

        public String getTencent_share_title() {
            return tencent_share_title;
        }

        public void setTencent_share_title(String tencent_share_title) {
            this.tencent_share_title = tencent_share_title;
        }

        public int getStoryboard_cnt() {
            return storyboard_cnt;
        }

        public void setStoryboard_cnt(int storyboard_cnt) {
            this.storyboard_cnt = storyboard_cnt;
        }

        public Object getNext_comic_id() {
            return next_comic_id;
        }

        public void setNext_comic_id(Object next_comic_id) {
            this.next_comic_id = next_comic_id;
        }

        public String getSina_share_title() {
            return sina_share_title;
        }

        public void setSina_share_title(String sina_share_title) {
            this.sina_share_title = sina_share_title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public BannerInfoBean getBanner_info() {
            return banner_info;
        }

        public void setBanner_info(BannerInfoBean banner_info) {
            this.banner_info = banner_info;
        }

        public String getTencent_share_params() {
            return tencent_share_params;
        }

        public void setTencent_share_params(String tencent_share_params) {
            this.tencent_share_params = tencent_share_params;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isIs_free() {
            return is_free;
        }

        public void setIs_free(boolean is_free) {
            this.is_free = is_free;
        }

        public TopicBean getTopic() {
            return topic;
        }

        public void setTopic(TopicBean topic) {
            this.topic = topic;
        }

        public int getSerial_no() {
            return serial_no;
        }

        public void setSerial_no(int serial_no) {
            this.serial_no = serial_no;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<?> getCustomized_share() {
            return customized_share;
        }

        public void setCustomized_share(List<?> customized_share) {
            this.customized_share = customized_share;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<ImageInfosBean> getImage_infos() {
            return image_infos;
        }

        public void setImage_infos(List<ImageInfosBean> image_infos) {
            this.image_infos = image_infos;
        }

        public static class ShareBean {
            /**
             * award : false
             * activity_id : null
             * show_draw_record : false
             * title :
             */

            private boolean award;
            private Object activity_id;
            private boolean show_draw_record;
            private String title;

            public boolean isAward() {
                return award;
            }

            public void setAward(boolean award) {
                this.award = award;
            }

            public Object getActivity_id() {
                return activity_id;
            }

            public void setActivity_id(Object activity_id) {
                this.activity_id = activity_id;
            }

            public boolean isShow_draw_record() {
                return show_draw_record;
            }

            public void setShow_draw_record(boolean show_draw_record) {
                this.show_draw_record = show_draw_record;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class BannerInfoBean {
            /**
             * type : 0
             */

            private int type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class TopicBean {
            /**
             * discover_image_url :
             * vertical_image_url : http://f2.kkmh.com/image/161226/th1gzi9gn.webp-w320
             * cover_image_url : http://f2.kkmh.com/image/161226/0nk746yec.webp-w640
             * description : 武力值MAX的道场继承人——向小满，为了追男神，决定江湖洗手，转校做一个安安静静的柔弱女子。而未曾想到的是，踏入校园第一天，男神还没追到，却因超凡的战斗力，被学校不良少年误认为男神。究竟小满能否成为男神心中的理想型，顺利转变现有的画风呢？【独家/每周四更新 责编：羊】
             * created_at : 1482734574
             * is_favourite : false
             * title : 当校霸爱上学霸
             * male_vertical_image_url : http://f2.kkmh.com/image/161226/th1gzi9gn.webp-w320
             * updated_at : 1482734574
             * special_offer : {}
             * is_free : true
             * id : 991
             * related_authors : [{"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180","grade":1,"nickname":"灿灿 ","reg_type":"weibo","id":28863310},{"pub_feed":0,"avatar_url":"http://f2.kkmh.com/default_avatar_image.jpg-w180","grade":1,"nickname":"夏天岛","reg_type":"weibo","id":96094336}]
             * user : {"pub_feed":1,"avatar_url":"http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180","grade":1,"nickname":"灿灿 ","reg_type":"weibo","id":28863310}
             * label_id : 44
             * male_cover_image_url : http://f2.kkmh.com/image/161226/0nk746yec.webp-w640
             * order : 480
             * comics_count : 58
             * status : published
             */

            private String discover_image_url;
            private String vertical_image_url;
            private String cover_image_url;
            private String description;
            private int created_at;
            private boolean is_favourite;
            private String title;
            private String male_vertical_image_url;
            private int updated_at;
            private SpecialOfferBean special_offer;
            private boolean is_free;
            private int id;
            private UserBean user;
            private int label_id;
            private String male_cover_image_url;
            private int order;
            private int comics_count;
            private String status;
            private List<RelatedAuthorsBean> related_authors;

            public String getDiscover_image_url() {
                return discover_image_url;
            }

            public void setDiscover_image_url(String discover_image_url) {
                this.discover_image_url = discover_image_url;
            }

            public String getVertical_image_url() {
                return vertical_image_url;
            }

            public void setVertical_image_url(String vertical_image_url) {
                this.vertical_image_url = vertical_image_url;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public boolean isIs_favourite() {
                return is_favourite;
            }

            public void setIs_favourite(boolean is_favourite) {
                this.is_favourite = is_favourite;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getMale_vertical_image_url() {
                return male_vertical_image_url;
            }

            public void setMale_vertical_image_url(String male_vertical_image_url) {
                this.male_vertical_image_url = male_vertical_image_url;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public SpecialOfferBean getSpecial_offer() {
                return special_offer;
            }

            public void setSpecial_offer(SpecialOfferBean special_offer) {
                this.special_offer = special_offer;
            }

            public boolean isIs_free() {
                return is_free;
            }

            public void setIs_free(boolean is_free) {
                this.is_free = is_free;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public int getLabel_id() {
                return label_id;
            }

            public void setLabel_id(int label_id) {
                this.label_id = label_id;
            }

            public String getMale_cover_image_url() {
                return male_cover_image_url;
            }

            public void setMale_cover_image_url(String male_cover_image_url) {
                this.male_cover_image_url = male_cover_image_url;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getComics_count() {
                return comics_count;
            }

            public void setComics_count(int comics_count) {
                this.comics_count = comics_count;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<RelatedAuthorsBean> getRelated_authors() {
                return related_authors;
            }

            public void setRelated_authors(List<RelatedAuthorsBean> related_authors) {
                this.related_authors = related_authors;
            }

            public static class SpecialOfferBean {
            }

            public static class UserBean {
                /**
                 * pub_feed : 1
                 * avatar_url : http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180
                 * grade : 1
                 * nickname : 灿灿
                 * reg_type : weibo
                 * id : 28863310
                 */

                private int pub_feed;
                private String avatar_url;
                private int grade;
                private String nickname;
                private String reg_type;
                private int id;

                public int getPub_feed() {
                    return pub_feed;
                }

                public void setPub_feed(int pub_feed) {
                    this.pub_feed = pub_feed;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public int getGrade() {
                    return grade;
                }

                public void setGrade(int grade) {
                    this.grade = grade;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getReg_type() {
                    return reg_type;
                }

                public void setReg_type(String reg_type) {
                    this.reg_type = reg_type;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }

            public static class RelatedAuthorsBean {
                /**
                 * pub_feed : 1
                 * avatar_url : http://f2.kkmh.com/image/161226/qcezbh4i7.webp-w180
                 * grade : 1
                 * nickname : 灿灿
                 * reg_type : weibo
                 * id : 28863310
                 */

                private int pub_feed;
                private String avatar_url;
                private int grade;
                private String nickname;
                private String reg_type;
                private int id;

                public int getPub_feed() {
                    return pub_feed;
                }

                public void setPub_feed(int pub_feed) {
                    this.pub_feed = pub_feed;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public int getGrade() {
                    return grade;
                }

                public void setGrade(int grade) {
                    this.grade = grade;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getReg_type() {
                    return reg_type;
                }

                public void setReg_type(String reg_type) {
                    this.reg_type = reg_type;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }

        public static class ImageInfosBean {
            /**
             * width : 1280
             * key : 41051882dd3404d4f0d1a5adb0f59edb
             * height : 1000
             */

            private int width;
            private String key;
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
