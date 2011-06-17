package com.adx.core.dp;

import com.adx.core.domain.Ad;
import com.adx.core.domain.DomainObject;
import com.adx.core.domain.Keyword;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.UUID;


public class InMemoryDocumentStoreTest {

    private ArrayList<Ad> ads = new ArrayList<Ad>(20);
    private DocumentStore inMemoryDS = new InMemoryDocumentStore();

    @BeforeClass
    public void init() {
        ads.add(createAd("ad1",
                new Keyword("wild elephant",Keyword.MatchTypes.PHRASE),
                new Keyword("elephant",Keyword.MatchTypes.EXACT),
                new Keyword("wild life",Keyword.MatchTypes.PHRASE),
                new Keyword("wild cat",Keyword.MatchTypes.BROAD)
        ));
        ads.add(createAd("ad2",
                new Keyword("wild elephant",Keyword.MatchTypes.PHRASE),
                new Keyword("elephant",Keyword.MatchTypes.EXACT),
                new Keyword("wild life",Keyword.MatchTypes.PHRASE),
                new Keyword("wild cat",Keyword.MatchTypes.BROAD)
        ));
        ads.add(createAd("ad3",
                new Keyword("sport car",Keyword.MatchTypes.PHRASE),
                new Keyword("ferrari",Keyword.MatchTypes.EXACT),
                new Keyword("sports utility vehicle",Keyword.MatchTypes.PHRASE),
                new Keyword("fast car",Keyword.MatchTypes.BROAD)
        ));
        ads.add(createAd("ad4",
                new Keyword("java",Keyword.MatchTypes.PHRASE),
                new Keyword("c",Keyword.MatchTypes.EXACT),
                new Keyword("computer geek",Keyword.MatchTypes.PHRASE),
                new Keyword("java modula",Keyword.MatchTypes.BROAD)
        ));
        ads.add(createAd("ad5",
                new Keyword("fasion show",Keyword.MatchTypes.PHRASE),
                new Keyword("photo shoot",Keyword.MatchTypes.EXACT),
                new Keyword("wild life photography",Keyword.MatchTypes.PHRASE),
                new Keyword("wedding photography",Keyword.MatchTypes.BROAD)
        ));

    }


    private Ad createAd(String name, Keyword ... keywords) {
        Ad ad = new Ad(name);
        ad.setId(UUID.randomUUID().toString());
        for (int i = 0; i < keywords.length; i++) {
            Keyword keyword = keywords[i];
            ad.addKeyword(keyword);
        }
        return ad;
    }

    @Test
    public void insertDocument() {
        inMemoryDS.store(ads.toArray(new Ad[]{}));
        Assert.assertEquals(inMemoryDS.getStoreSize(), 5, "Size does not match");
        DomainObject ad = inMemoryDS.getDocument(ads.get(4).getId());
        Assert.assertNotNull(ad);
        Assert.assertEquals(ad.getId(),ads.get(4).getId(),"Objects does not match");
    }

}
