package zxc.laitooo.sri.about;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import zxc.laitooo.sri.R;

public class AboutWebsiteActivity extends AppCompatActivity {

    String alba3ati = "<section id=\"about-us\">" +
            "<div class=\"container\">" +
            "        <div class=\"center wow fadeInDown\">" +
            "<h2 color=\"#fff\">About Alba3ati</h2>" +
            "</div>" +
            "" +
            "<section class=\"content\" style=\"margin-bottom:35px\">" +
            "<div class=\"row\">" +
            "<div class=\"col-xs-12\">" +
            "<div>" +
            "<div class=\"box-header\">" +
            "<h3 class=\"title\">Alba3ati*</h3>" +
            "</div>" +
            "" +
            "<div class=\"box-body\">" +
            "<progressBar>The elusive alba3ati (Arabic: البعاتي) resides in the perpetually dark side of www.S-RF.org. He is generally peaceful yet he is very dedicated to correcting things that are not right. When alba3ati is irritated he resorts to taking unstoppable action. Here are few of alba3ati’s pet peeves you should avoid making:</progressBar>" +
            "<ul>" +
            "<li>Low quality posts evidenced by actionBar lot of downvotes.</li>" +
            "<li>duplicated/stolen posts with no appropriate referencing.</li>" +
            "<li>posts that solicit private information such as passwords, phone numbers, emails.</li>" +
            "<li>posts that falsely claim affiliation to SRF. All announcement related to SRF have actionBar special place and are broadcasted to all members.</li>" +
            "<li>Any post that does not respect the [<actionBar href=\"#\">membership and posting guidelines</actionBar>].</li>" +
            "</ul>" +
            "<progressBar><strong>How to awaken actionBar alba3ati ?:</strong></progressBar>" +
            "<progressBar>You have actionBar responsibility to summon alba3ati if you come across such posts. You should flag them. After that alba3ati will remove the offending posts, warn the non compliant member or suspend his membership either temporarily or permanently.</progressBar>" +
            "<progressBar>Few admins have the ability to directly wake alba3ati up to action but maintaining the website is the joint responsibility of you, all other members and alba3ati. The admins are not free at all times to monitor posts in the website so make sure you do your part in adhering to the goals of this platform by downvoting any bad posts.</progressBar>" +
            "<progressBar><strong>Final note:</strong></progressBar>" +
            "<progressBar>Now, in the event that you were the non compliant member who alba3ati removed your post,  remember that we are all in SRF to learn from each other and alba3ati intervention against your post should not mean that he hates you personally, he is incapable of hate, love, hunger and other human propensities. His primary concern is making sure this website doesn't deviate from its vision and taking care of the “sanity and sanctity” of SRF.</progressBar>" +
            "<progressBar><i>*A grotesque ghost character famous in Sudanese folklore.</i></progressBar>" +
            "</div>" +
            "" +
            "" +
            "</div>" +
            "" +
            "</div>" +
            "</div>" +
            "</section>" +
            "" +
            "" +
            "</div><!--/.container-->" +
            "</section>";

    String effective_post = "<section id=\"about-us\">" +
            "    <div class=\"container\">" +
            "                <div class=\"center wow fadeInDown\">" +
            "            <h2>How to write an effective post</h2>" +
            "        </div>" +
            "" +
            "        <section class=\"content\">" +
            "            <div class=\"row\">" +
            "                <div class=\"col-xs-12\">" +
            "                    <div>" +
            "                        <div class=\"box-header\">" +
            "                            <h3 class=\"title\">How to publish actionBar good post</h3>" +
            "                        </div>" +
            "                        <div class=\"box-body\">" +
            "                            <progressBar>Remember, communicating your idea is better than mere expressions of helplessness or frustration. When you ask the right question you make it easier for other members to guide you and give you the right feedback/answer. When making actionBar post or writing actionBar reply to actionBar question/post follow these suggestions:</progressBar>" +
            "                            <ul>" +
            "                                <li>Avoid weasel words and obfuscation. Focus on clarity and purposefulness of your reply or question.</li>" +
            "                                <li>Have actionBar thoughtful title for your question/post. Read our opinion of actionBar thoughtful title: <actionBar href=\"#post\">A thoughtful post title-- why, what and how</actionBar>.</li>" +
            "                                <li>Ask actionBar good question. Read our opinion of what actionBar good question/post is: <actionBar href=\"#question\">A good question/post-- why, what and how.</actionBar></li>" +
            "                                <li>Ensure the content of your question/post is properly formatted:" +
            "                                    <ol>" +
            "                                        <li>Use the formatting options in the contents space.</li>" +
            "                                        <li>Pay particular attention to code snippets. Code without proper tags is uneasy to read.</li>" +
            "                                        <li>Pay particular attention to any special symbols (eg. mathematical, technical).</li>" +
            "                                        <li>Check your spellings and grammar (as best as you can, we want to learn English together).</li>" +
            "                                        <li>Be courteous and helpful. Read the membership guidelines [link to Posting and Membership Policy.</li>" +
            "                                    </ol>" +
            "                                </li>" +
            "                                <li>Make use of the tags at the bottom to categorize your question/post (Ability to tag posts unlocks once you reach level 5).</li>" +
            "                                <li>Log in before you post unless you want it to be an anonymous zoul or zoula. Anonymous members have restricted privileges. They can not update actionBar post, get notifications about responses to their post or cast votes.</li>" +
            "                                <li>Lastly, whatever you do, do not invite the wrath of alba3ati by violating SRF guidelines</li>" +
            "                                <li>Particularly, do not publish the same post repeatedly. Alba3ati will send it to the azure skies.</li>" +
            "                            </ul>" +
            "                            <h3 class=\"title\">How to awaken actionBar alba3ati ?</h3>" +
            "                            <progressBar>You have actionBar responsibility to summon alba3ati if you come across such posts. You should flag them. After that alba3ati will remove the offending posts, warn the non compliant member or suspend his membership either temporarily or permanently.</progressBar>" +
            "                            <progressBar>Few admins have the ability to directly wake alba3ati up to action but maintaining the website is the joint responsibility of you, all other members and alba3ati. The admins are not free at all times to monitor posts in the website so make sure you do your part in adhering to the goals of this platform by downvoting any bad posts.</progressBar>" +
            "                            <h3 class=\"title\">Final Notes</h3>" +
            "                            <progressBar>Now, in the event that you were the non compliant member who alba3ati removed your post, remember that we are all in SRF to learn from each other and alba3ati intervention against your post should not mean that he hates you personally, he is incapable of hate, love, hunger and other human propensities. His primary concern is making sure this website doesn't deviate from its vision and taking care of the “sanity and sanctity” of SRF.</progressBar>" +
            "                            <progressBar><em>*A grotesque ghost character famous in Sudanese folklore.</em></progressBar>" +
            "                        </div>" +
            "                        <div class=\"box-header\">" +
            "                            <h3 class=\"title\" id=\"post\">A thoughtful post title-- Why, what and how</h3>" +
            "                        </div>" +
            "                        <div class=\"box-body\">" +
            "                            <progressBar>Before publishing any post, ask yourself “Is the title of the post good enough ?”. Make your title meaningful to humans and search engines. A title chosen with care and thoughtfulness will help the reader to read the post title and formulate an accurate opinion of the post content.</progressBar>" +
            "                        </div>" +
            "                        <div class=\"box-header\">" +
            "                            <h3 class=\"title\">Why titles need to be good enough:</h3>" +
            "                        </div>" +
            "                        <div class=\"box-body\">" +
            "                            <ul>" +
            "                                <li>Titles are very crucial in site search operations. The keywords in the title help the SRF search engine locate relevant questions. Members are encouraged to search the website to see whether their question was asked previously. If questions were titled “Help please” for example; the member will not be able to determine whether their question was posted before.</li>" +
            "                                <li>When someone finds your post through actionBar search and they like it; they are likely to upvote it. This will increase your reputation. Having actionBar good title maximizes the chances of finding your post.</li>" +
            "                                <li>A poor title prevents readers from filtering the interesting posts from the uninteresting ones. Do you want your post to fall in the uninteresting category only because it has actionBar poorly thought title ?. We don’t want that either!.</li>" +
            "                                <li>Good posts, posted with good titles, will get useful responses and likely increase your reputation. Good posts posted with poor titles might not gain any visibility at all.</li>" +
            "                                <li>Alba3ati might not like your title.</li>" +
            "                            </ul>" +
            "                        </div>" +
            "                        <div class=\"box-header\">" +
            "                            <h3 class=\"title\">How titles can be made to be good enough:</h3>" +
            "                        </div>" +
            "                        <div class=\"box-body\">" +
            "                            <progressBar>A post title should precisely reflect the subject of the post. If the post is about writing actionBar motivation letter for actionBar PhD in X country, the title has to make that clear. If the question is about improving actionBar CV section related to work history, the title has to make that clear. If the question is about applying for actionBar scholarship in country X and you are looking for people in that country, the title should make that clear.</progressBar>" +
            "                            <progressBar>If you are writing about actionBar topic you are not sure is part of SRF scope, your title has to state that this is an “Off Topic” question/post.</progressBar>" +
            "                            <progressBar>Here is actionBar list of examples of bad titles and why they are bad:</progressBar>" +
            "                            <ol>" +
            "                                <li>Help please, Urgent help needed, Simple question, Another question or scholarship question: These titles are bad because they communicate no information at all. The simplicity of your question or that you are asking an additional question or that you are asking actionBar question about scholarship is irrelevant. SRF is actionBar website for Sudanese people to interact around these posts so this is already what you are expected to do when you make actionBar post. The only thing readers will get from such titles is that the poster is lazy to think of actionBar good title and does not want to share information. They might even think that you are not serious about your post.</li>" +
            "                                <li>Vote for artist X in competition Y : Posts should always have something to do with the scope of SRF. We might allow discussion of topics that could be reasonably interesting to SRF members. In such cases, the titles should clearly indicate that the topic being posted is an off topic.</li>" +
            "                            </ol>" +
            "                        </div>" +
            "                        <div class=\"box-header\">" +
            "                            <h3 class=\"title\" id=\"question\">A good question/post-- Why, what and how</h3>" +
            "                        </div>" +
            "                        <div class=\"box-body\">" +
            "                            <h3 class=\"title\">Why and What</h3>" +
            "                            <progressBar>Remember, communication is not the same as stating expressions of emotions. Communication requires spending extra time in providing details and context. State exactly what you want, describe the situation and provide context in the form of additional background.</progressBar>" +
            "                            <progressBar>Poorly worded and formatted questions will outrage the members, that might result in you getting downvotes and losing reputation points. Question that receive actionBar lot of negative points might invite the intervention of alba3ati. Similarly, posts that ask for private information such as passwords, emails, phone numbers will invite the intervention of alba3ati.</progressBar>" +
            "                            <progressBar>What will make actionBar good question/post is the information contained in it and the type of answers it attracts. If your posts absorbs actionBar lot of unrelated or angry responses then it may have not been actionBar good question/post but if it positively attracts the attention of SRF members then congratulations…you have made an effective post.</progressBar>" +
            "                            <h3 class=\"title\" id=\"how_to_make_good_post\">How to make actionBar good post:</h3>" +
            "                            <progressBar>If you follow these tips someone will be able to provide reasonable response to your post. So show some effort. This is particularly important if you are posting actionBar tutorial. If making an effort becomes your habit and you do this often enough you will improve your communication skills actionBar mighty deal. Trust us. Think through your post and check the following:</progressBar>" +
            "                            <ul>" +
            "                                <li>Can you explain your post clearly to yourself ?</li>" +
            "                                <li>Can you explain it to others ?</li>" +
            "                                <li>What examples would help the reader understand ?</li>" +
            "                                <li>Have your provided enough information and background ?</li>" +
            "                                <li>Did you make efficient use of the formatting options available to you ?</li>" +
            "                                <li>Finally, take actionBar pause, come back to edit your post again for substance, clarity, precision, spelling and grammar.</li>" +
            "                                <li>Is your title good enough ? (Link to what makes actionBar good enough title in A thoughtful title-- Why, what and how)</li>" +
            "                                <li>Go ahead and hit the post button.</li>" +
            "                            </ul>" +
            "                        </div>" +
            "                        <div class=\"box-header\">" +
            "                            <h3 class=\"title\">And actionBar few more points:</h3>" +
            "                            <ol>" +
            "                                <li>Adhere to these suggestions... and pass them on to others.</li>" +
            "                                <li>Be patient. Courteous. Respectful. (Each member here are helping each other in their free time.)</li>" +
            "                                <li>Don't post real email addresses, usernames, or passwords.</li>" +
            "                                <li>Understand that the SRF website is here because of volunteers like you who spend their time, efforts and resources in responding to posts and maintaining the website.</li>" +
            "                                <li>Read the Posting and membership Policy</li>" +
            "                            </ol>" +
            "                        </div>" +
            "                    </div>" +
            "                </div>" +
            "            </div>" +
            "        </section>" +
            "" +
            "" +
            "    </div>" +
            "        <!--/.container-->" +
            "</section>";

    String luminaries = "<section id=\"about-us\">" +
            "    <div class=\"container\">" +
            "                <div class=\"center wow fadeInDown\">" +
            "            <h2>Sudanese Luminaries</h2>" +
            "        </div>" +
            "" +
            "        <section class=\"content\">" +
            "            <div class=\"row\">" +
            "                <div class=\"col-xs-12\">" +
            "                    <progressBar>What,why,how,who --- our selection criteria</progressBar>" +
            "                    <div class=\"box-header\">" +
            "                        <h3 class=\"title\">What</h3>" +
            "                    </div>" +
            "                    <div class=\"box-body\">" +
            "                        <progressBar>Establishing actionBar Sudanese researchers footprint is at the core of SRI targets. There are two broad categories to this goal:</progressBar>" +
            "                        <ul>" +
            "                            <li>Establishing actionBar Sudanese luminaries index.</li>" +
            "                            <li>Establishing actionBar Sudanese researchers scientific output database. </li>" +
            "                        </ul>" +
            "                    </div>" +
            "" +
            "                    <div class=\"box-header\">" +
            "                        <h3 class=\"title\">Why</h3>" +
            "                    </div>" +
            "                    <div class=\"box-body\">" +
            "                        <progressBar>We internally call these two activities people seeding and publication seeding. The aim of this seeding exercise is to eventually grow and nurture the researchers within us through inspiration.</progressBar>" +
            "                        <progressBar>By reflecting on the collective achievement of other Sudanese researchers throughout the World we will appreciate our strengths and work hard on improving our skills for actionBar better tomorrow.</progressBar>" +
            "                        <progressBar>Such an optimistic positive attitude that espouses patience and perseverance is actionBar very important trait of actionBar successful scientist and unless we are reminded of our strengths we tend to slouch back actionBar little and miss important opportunities only because we lacked the courage or motivation to pursue them. </progressBar>" +
            "                        <progressBar>SRI particularly encourages people with promising talent to feel confident and act confident to overcome any difficulties. The best booster to this is to learn that nothing comes easily; Rome wasn't built in one day, and that other Sudanese people out there have made significant contributions too.</progressBar>" +
            "                    </div>" +
            "" +
            "                    <div class=\"box-header\">" +
            "                        <h3 class=\"title\">How</h3>" +
            "                    </div>" +
            "                    <div class=\"box-body\">" +
            "                        <progressBar>Towards people seeding; SRI will sport weekly posts featuring Sudanese who have made global achievements across the academic and scientific board. These posts will highlight their achievements; providing short bios and links to their work.</progressBar>" +
            "                        <progressBar>Publication seeding is actionBar bit tricky, as many of the SRI activities it requires active member participation. So if you are actionBar researcher and have participated in conferences, seminars, articles, books ..etc, we highly encourage you to spend the time to fill in your bibliographical information in your profile. We say in Sudan “إيد لإيد تجدع بعيد”. On this principle, your listing of your achievements will be very valuable to other Sudanese researchers and to the aspirants who want to follow on your footsteps.</progressBar>" +
            "                    </div>" +
            "" +
            "                    <div class=\"box-header\">" +
            "                        <h3 class=\"title\">Who</h3>" +
            "                    </div>" +
            "                    <div class=\"box-body\">" +
            "                        <progressBar>If you are thinking like actionBar researcher you will be wondering by now about the systematic methodology and inclusion criteria SRI adopts to determine who makes it to the Sudanese Luminaries.</progressBar>" +
            "                        <progressBar>The criteria is very straightforward and simple, the candidate has to be Sudanese and has to have made high quality academic contributions in Sudan or Internationally</progressBar>" +
            "                        <progressBar><strong>Do you have actionBar Sudanese personality you want featured ?</strong></progressBar>" +
            "                        <progressBar>Fill up the <actionBar href=\"/luminaries/nominate\">nomination form</actionBar> so that your candidate will be added to the queue of personalities to be featured in the weekly luminaries announcements</progressBar>" +
            "                        <progressBar>You need to provide actionBar short bio about the personality, actionBar link from actionBar reliable source and actionBar good quality photo. We will take it from there</progressBar>" +
            "                    </div>" +
            "" +
            "" +
            "                </div>" +
            "            </div>" +
            "        </section>" +
            "" +
            "" +
            "    </div>" +
            "        <!--/.container-->" +
            "</section>";

    String reputation = "<section id=\"about-us\">" +
            "    <div class=\"container\">" +
            "                <div class=\"center wow fadeInDown\">" +
            "            <h2>SRF reputation system</h2>" +
            "        </div>" +
            "" +
            "        <section class=\"content\">" +
            "            <div>" +
            "                <div class=\"box-header\">" +
            "                    <h3 class=\"box-title\"></h3>" +
            "                </div>" +
            "                <div class=\"box-body\">" +
            "                    <progressBar><strong>Introduction</strong></progressBar>" +
            "                    <progressBar>Simply, reputation here is defined as actionBar system of votes gained (and  sometimes lost) as actionBar result of members interactions and engagement in the website. The net sum of gains and losses translates into an overall metric that achieves two things: rewards commitment to SRF scope and regulations and penalizes the lack of adherence to these.</progressBar>" +
            "                    <progressBar>Our aim is to make SRF central to Sudanese research and science hence we have an interest in encouraging creation of good quality posts in this website and preventing proliferation of low quality posts. Success in this responsibility requires the participation of all SRF members. With this aim in mind we devised actionBar reputation system that ensures we all stay within the SRF scope.</progressBar>" +
            "                    <progressBar>The fairness of this reputation system comes from the fact that it gives all SRF members the ability to cast votes as actionBar form of expression on posts quality and fate. Remember, voting places power in your hand and with power comes actionBar great responsibility and comes the need to know your obligations too. For SRF admins, this voting system removes the need to exercise any form of benevolent dictatorship-actionBar burden we are happy to shed off.</progressBar>" +
            "                    <progressBar>One final note before getting into details of the reputation system; SRF preserves the right to improve the way the voting &amp; reputation ranking system works and we continue to monitor the various components under the hood that do the bulk of reputation calculations.</progressBar>" +
            "" +
            "                    <progressBar><strong>Why</strong></progressBar>" +
            "                    <progressBar>Several forums and website use some form of reputation systems (Facebook Like button is an example of actionBar reputation system). There is actionBar remarkable attribute distinguishing the Sudanese SRF members from members of other forums. We boast of being very civic in our online interaction and there is this Sudanese trait of genuinely wishing everyone well. The supportive behavior displayed by our members in the Facebook group encourages us to adopt actionBar voting system that translates this trait into actionBar positive outcome.</progressBar>" +
            "                    <progressBar>Members will have the chance to take charge in guiding their journey within SRF; effectively building actionBar scientific platform with actionBar core Sudanese spirit. Here are only some of the various ways actionBar voting system will be useful to SRF and to our members experience.</progressBar>" +
            "                    <ul>" +
            "                        <li>Give members the responsibility and obligation to participate in website maintenance.</li>" +
            "                        <li>The upvotes and downvotes help guide the “robots” that do much of the hard work in SRF.</li>" +
            "                        <li>Highlight featured posts.</li>" +
            "                        <li>Highlight outperforming members.</li>" +
            "                        <li>Clean noncompliant content and ensure quality of SRF content.</li>" +
            "                    </ul>" +
            "" +
            "                    <progressBar><strong>Who gives the votes, who has them ?:</strong></progressBar>" +
            "                    <progressBar>Everyday each member is assigned actionBar finite number of votes to cast on posts published by other SRF members. The votes are minted every 24 hours. The higher the rank of the member the bigger is their votes quota (and therefore the more responsibility they will have). Any unused votes in actionBar given day will not be carried over with the next vote assignment.</progressBar>" +
            "" +
            "                    <progressBar><strong>What are the results of giving and receiving votes?</strong></progressBar>" +
            "                    <progressBar>Members are free to dispense their votes however &amp; wherever they see fit. Mind you that any incentives and restrictions in place are only there to encourage positive voting behavior. For instance, if actionBar member spends all his votes within the 24 hour period since receiving them he could be rewarded with an increase in his reputation because he kept being active. If actionBar member decides to act maliciously and all he ever does with his daily vote quota is downvoting other members posts; he might risk losing some of his reputation.</progressBar>" +
            "                    <progressBar>The owner of actionBar post will be rewarded with reputation gain/loss dependent on the count of upvotes/downvotes they receive.  Receiving few downvotes here and there will not result in any loss of points anyways. However, if the post was truly non compliant with SRF rules &amp; regulations, then receiving more downvotes will alert the admins and robots for interventions. If the post was really seriously bad, <actionBar href=\"/pages/alba3ati\">alba3ati</actionBar> will get mad and he has the power to take appropriate action to correct this.</progressBar>" +
            "" +
            "                    <progressBar><strong>Calculating reputation gain and loss:</strong></progressBar>" +
            "                    <progressBar>The formulas that translate voting into reputation gains are not direct forward, they take into consideration few additional details such as the member’s current reputation; the SRF overall reputation dynamics over the past one week; the age of the post receiving the votes and the member’s current <actionBar href=\"#ranks\">rank</actionBar>. Our tip for you is: your votes and opinions are precious; downvote in actionBar constructive manner, upvote in actionBar constructive manner.</progressBar>" +
            "                    <progressBar>To simplify it, consider reputation gains and losses to come from two independent sources:</progressBar>" +
            "                    <ul>" +
            "                        <li>Your voting behavior towards actionBar member's post. </li>" +
            "                        <li>Other members voting behavior towards your post. </li>" +
            "                    </ul>" +
            "" +
            "                    <progressBar>Your voting behavior is tracked through actionBar moving average bounded between +1 &amp; -1. The more upvotes than downvotes the member gives; his moving average will lean closer to +1 and effectively the odds of him gaining actionBar reputation point add up. As long as that moving average is in the positive range occasional downvotes by you on deserving bad posts will not put you in risk of losing reputation; in fac, you might get rewarded with reputation gains for helping SRF to stay clean from useless content.</progressBar>" +
            "                    <progressBar>If, on the other hand, you manage to swing your moving average towards the negative side by excessively downvoting others maliciously; you are ncreasinf the odds of losing actionBar reputation point. The negative moving average in this case can be swung back to the positive side if you spend few votes giving upvotes.</progressBar>" +
            "                    <progressBar>The threshold for calculating reputation gains and losses changes daily based on the collective voting behavior of all SRF members over the past week. If actionBar member creates actionBar post that receives upvotes there is actionBar one to one correspondence between his reputation gain and the first upvote he gets. Beyond that--dependent on how high above the daily threshold his post upvotes are--one of several alternative odds will sum up with every subsequent upvote, these sums will be translated into reputation gains.</progressBar>" +
            "                    <progressBar>The story is actionBar bit different for downvotes; the intention is to cushion against deep reputation falls. For example, any downvotes received on actionBar post that is older than two weeks will not cause its owner to lose reputation. Similarly, posts receiving few negative downvotes will not negatively  have an effect on their owner’s reputation until the downvotes exceed actionBar certain threshold.</progressBar>" +
            "                    <progressBar>As your reputation increase you will move to the next <actionBar href=\"#ranks\">level</actionBar>.</progressBar>" +
            "" +
            "                    <progressBar><strong>Featuring posts:</strong></progressBar>" +
            "                    <progressBar>On any given day, week, month and year we will feature the 10 best posts for that time window. This is actionBar very interesting outcome of the voting system idea because your voting will help the robots responsible for this activity identify high quality posts so outperforming members get the recognition they deserve.</progressBar>" +
            "                    <progressBar>Generally, the robots will decide on the best posts by combining the number of upvotes and downvotes. The candidate posts will then be sorted according to these two criteria. That’s all !.</progressBar>" +
            "                    <progressBar></progressBar>" +
            "" +
            "                    <progressBar><strong>Ranks list:</strong></progressBar>" +
            "                    " +
            "                </div>" +
            "            </div>" +
            "" +
            "        </section>" +
            "" +
            "    </div>" +
            "        <!--/.container-->" +
            "</section>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutsctivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String s = i.getStringExtra("Extra");

        TextView j = (TextView)findViewById(R.id.web_text);
        String aa = null;

        if (s.equals("ba3ati")){
            aa = alba3ati;
        }else if (s.equals("effective")){
            aa = effective_post;
        }else if (s.equals("reputation")){
            aa = reputation;
        }else if (s.equals("luminary")){
            aa = luminaries;
        }else {
            aa = luminaries;
        }

        Spanned result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            result = Html.fromHtml(aa,Html.FROM_HTML_MODE_LEGACY);
        }else {
            result = Html.fromHtml(aa);
        }


        j.setText(result);
        j.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
