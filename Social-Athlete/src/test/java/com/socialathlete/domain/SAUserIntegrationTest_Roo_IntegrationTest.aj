// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.socialathlete.domain;

import com.socialathlete.domain.SAUser;
import com.socialathlete.domain.SAUserDataOnDemand;
import com.socialathlete.domain.SAUserIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SAUserIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SAUserIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SAUserIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: SAUserIntegrationTest: @Transactional;
    
    @Autowired
    private SAUserDataOnDemand SAUserIntegrationTest.dod;
    
    @Test
    public void SAUserIntegrationTest.testCountSAUsers() {
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", dod.getRandomSAUser());
        long count = SAUser.countSAUsers();
        Assert.assertTrue("Counter for 'SAUser' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SAUserIntegrationTest.testFindSAUser() {
        SAUser obj = dod.getRandomSAUser();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to provide an identifier", id);
        obj = SAUser.findSAUser(id);
        Assert.assertNotNull("Find method for 'SAUser' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'SAUser' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void SAUserIntegrationTest.testFindAllSAUsers() {
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", dod.getRandomSAUser());
        long count = SAUser.countSAUsers();
        Assert.assertTrue("Too expensive to perform a find all test for 'SAUser', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<SAUser> result = SAUser.findAllSAUsers();
        Assert.assertNotNull("Find all method for 'SAUser' illegally returned null", result);
        Assert.assertTrue("Find all method for 'SAUser' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SAUserIntegrationTest.testFindSAUserEntries() {
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", dod.getRandomSAUser());
        long count = SAUser.countSAUsers();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<SAUser> result = SAUser.findSAUserEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'SAUser' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'SAUser' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SAUserIntegrationTest.testFlush() {
        SAUser obj = dod.getRandomSAUser();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to provide an identifier", id);
        obj = SAUser.findSAUser(id);
        Assert.assertNotNull("Find method for 'SAUser' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifySAUser(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'SAUser' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void SAUserIntegrationTest.testMergeUpdate() {
        SAUser obj = dod.getRandomSAUser();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to provide an identifier", id);
        obj = SAUser.findSAUser(id);
        boolean modified =  dod.modifySAUser(obj);
        Integer currentVersion = obj.getVersion();
        SAUser merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'SAUser' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void SAUserIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", dod.getRandomSAUser());
        SAUser obj = dod.getNewTransientSAUser(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'SAUser' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'SAUser' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'SAUser' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void SAUserIntegrationTest.testRemove() {
        SAUser obj = dod.getRandomSAUser();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'SAUser' failed to provide an identifier", id);
        obj = SAUser.findSAUser(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'SAUser' with identifier '" + id + "'", SAUser.findSAUser(id));
    }
    
}
