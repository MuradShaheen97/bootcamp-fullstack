import { useState } from "react";

const Tabs = ({ tabs }) => {
  const [selectedTab, setSelectedTab] = useState(0);

  return (
    <div>
      {/* Tab Buttons */}
      <div className="tab-buttons">
        {tabs.map((tab, index) => (
          <button
            key={index}
            className={selectedTab === index ? "active" : ""}
            onClick={() => setSelectedTab(index)}
          >
            {tab.label}
          </button>
        ))}
      </div>

      {/* Content */}
      <div className="tab-content">{tabs[selectedTab].content}</div>
    </div>
  );
};

export default Tabs;
