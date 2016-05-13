package com.donkamillo.gojimoqualification.services;

import java.util.List;

/**
 * Created by DonKamillo on 13.05.2016.
 */
public class GojimoResponse {
    private String id;
    private String name;
    private Country country;
    private String link;
    private List<DefaultProduct> default_products;
    private List<Subject> subjects;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public String getLink() {
        return link;
    }

    public List<DefaultProduct> getDefault_products() {
        return default_products;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public class DefaultProduct {
        private String id;
        private String title;
        private String ios_iap_id;
        private List<StoreId> store_ids;
        private String link;
        private String type;
        private String author;
        private List<Asset> assets;
        private Publisher publisher;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getIos_iap_id() {
            return ios_iap_id;
        }

        public List<StoreId> getStore_ids() {
            return store_ids;
        }

        public String getLink() {
            return link;
        }

        public String getType() {
            return type;
        }

        public String getAuthor() {
            return author;
        }

        public List<Asset> getAssets() {
            return assets;
        }

        public Publisher getPublisher() {
            return publisher;
        }
    }

    public class StoreId {

    }

    public class Publisher {
        private String id;
        private String title;
        private String link;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }
    }

    public class Asset {
        private String id;
        private String copyright;
        private String meta;
        private int size;
        private String content_type;
        private String created_at;
        private String updated_at;
        private String path;
        private String unzipped_base_url;

        public String getId() {
            return id;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getMeta() {
            return meta;
        }

        public int getSize() {
            return size;
        }

        public String getContent_type() {
            return content_type;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getPath() {
            return path;
        }

        public String getUnzipped_base_url() {
            return unzipped_base_url;
        }
    }

    public class Subject {
        private String id;
        private String title;
        private String link;
        private String colour;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getColour() {
            return colour;
        }
    }


    public class Country {
        private String code;
        private String name;
        private String created_at;
        private String updated_at;
        private String link;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getLink() {
            return link;
        }
    }




}
