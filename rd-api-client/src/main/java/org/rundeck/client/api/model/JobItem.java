/*
 * Copyright 2017 Rundeck, Inc. (http://rundeck.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.rundeck.client.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.rundeck.client.util.DataOutput;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement()
public class JobItem implements DataOutput {
    private String id;
    private String name;
    private String group;
    private String project;
    private String description;
    private String href;
    private String permalink;

    private Long averageDuration;

    @XmlElement()
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement()
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @XmlElement
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlAttribute()
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @XmlElement()
    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @Override
    public String toString() {
        return "org.rundeck.client.api.model.JobItem{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", group='" + group + '\'' +
               ", project='" + project + '\'' +
               ", description='" + description + '\'' +
               ", href='" + href + '\'' +
               ", permalink='" + permalink + '\'' +
               '}';
    }

    public Map<Object, Object> toMap() {
        HashMap<Object, Object> map = new LinkedHashMap<>();
        map.put("id", getId());
        map.put("name", getName());
        if (null != getGroup()) {
            map.put("group", getGroup());
        }
        map.put("project", getProject());
        map.put("href", getHref());
        map.put("permalink", getPermalink());
        map.put("description", getDescription());
        if(null!=getAverageDuration()){
            map.put("averageDuration", getAverageDuration());
        }
        return map;
    }

    @Override
    public Map<?, ?> asMap() {
        return toMap();
    }

    public String toBasicString() {
        return String.format("%s %s%s", id, group != null ? group + "/" : "", name != null ? name : "");
    }

    @XmlAttribute()
    public Long getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(Long averageDuration) {
        this.averageDuration = averageDuration;
    }
}
